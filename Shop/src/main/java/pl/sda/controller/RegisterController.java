package pl.sda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.model.*;
import pl.sda.service.RegisterService;


@Controller
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @RequestMapping(value = "newShopperForm.do", method = RequestMethod.GET) //newShopperForm
    public ModelAndView newShopperForm() {

        ModelAndView mav = new ModelAndView("register");

        mav.getModelMap().put("newUser", new User());
        mav.getModelMap().put("newShopper", new Shopper());
        return mav;
    }

    @RequestMapping(value = "register.do", method = RequestMethod.POST)
    public String createNewShopper (@ModelAttribute("user") User user, @ModelAttribute("shopper")Shopper shopper) {

        user.setUserRoleType(UserRoleType.USER);
        user.setShopperS(shopper);

        return registerService.newUser(user, shopper) ?
                "redirect:newLogin.do" : "redirect:newShopperForm.do";
    }
}