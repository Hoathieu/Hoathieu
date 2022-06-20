/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import DAO.AccountDAO;
import entities.TblAccount;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author nhine
 */
@Controller
@RequestMapping(value = "")
public class LoginController {
    AccountDAO dao;

    public LoginController() {
        dao = new AccountDAO();
    }
    
    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String login(Model model){
        TblAccount account = new TblAccount();
        model.addAttribute("account", account);
        return "login";
    }
    @RequestMapping(value = "processedLogin", method = RequestMethod.POST)
    public String processLogin(@Valid @ModelAttribute("account") TblAccount account, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("account", account);
            return "login";
        } else {
            String name = account.getAccLogin();
            if (dao.login(name,account.getAccPassword())) {
                model.addAttribute("account", account);
                sdgfghjjnkl
                return "home";
            }
            return "login";
        }
    }
}
