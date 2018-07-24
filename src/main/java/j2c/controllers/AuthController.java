package j2c.controllers;

import j2c.daos.AuthDao;
import j2c.pojos.Answer;
import j2c.pojos.Question;
import j2c.pojos.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @Autowired
    AuthDao adao;

    @RequestMapping(value="/j2c/auth",method= RequestMethod.GET)
    public String authenticate(@ModelAttribute("usr") User user, Model model) {

        User u = adao.authenticate(user.getEmail(), user.getPwd());
        model.addAttribute("usr",u);
        return "question";

    }


    @RequestMapping(value="/j2c/addUser",method=RequestMethod.POST)
    @ResponseBody
    public void addQuestion(@ModelAttribute("usr") User user, Model model) {
        adao.addUser(user);
        model.addAttribute("usr",user);
    }


}
