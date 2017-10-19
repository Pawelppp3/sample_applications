package pl.sda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import pl.sda.model.Basket;
import pl.sda.model.User;
import pl.sda.model.UserRoleType;
import pl.sda.service.LoginService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ShopLoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "newLogin.do", method = RequestMethod.GET)
    public ModelAndView login() {

        ModelAndView mav = new ModelAndView("login");
        mav.getModelMap().put("newUser", new User());

        return mav;
    }

    @RequestMapping(value = "logOut.do", method = RequestMethod.GET)
    public ModelAndView logOut(HttpServletRequest request) {

        request.getSession().invalidate();
        ModelAndView mav = new ModelAndView("login");
        mav.getModelMap().put("newUser", new User());

        return mav;
    }

    @RequestMapping(value = "login.do", method = RequestMethod.POST)
    public String create(@ModelAttribute("user") User user, HttpServletRequest request) {

        final UserRoleType roleType = loginService.loginByRole(user.getLogin(), user.getPassword());

        request.getSession().setAttribute("login", user.getLogin());
        request.getSession().setAttribute("basket", new Basket(user.getLogin()));

        switch (roleType) {
            case ADMIN:
                return "redirect:product.do";
            case USER:
                return "redirect:shopper.do";
            case NONE:
               return "redirect:login.do";
            default : return null;
        }
    }
}

