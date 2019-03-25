package com.lizutuk.parentalcontrol.controllors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
//import org.springframework.web.bind.annotation.ResponseBody;

//*** Created by Liz Utuk ***//


@Controller
@RequestMapping(value ="app")
public class AppController {

    static ArrayList<String> playlists = new ArrayList<>();
    //Request path: app/

    @RequestMapping(value = "")
    //@ResponseBody
    public String index(Model model){

        //ArrayList<String> playlists = new ArrayList<>();
        //playlists.add("ABC");
        //playlists.add("123");
        //playlists.add("Colors");

        model.addAttribute("playlists", playlists);
        model.addAttribute("title", "My Parental Control App");
        return "app/index";
    }

    //Request path: app/add
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddAppForm(Model model) {
        model.addAttribute("title", "Add Playlist");
        return "app/add";
    }

    //Request path: app/add
    @RequestMapping(value= "add", method = RequestMethod.POST)
    public String processAddAppForm(@RequestParam String playlistName) {

        playlists.add(playlistName);

        //Redirect to app/
        return "redirect:";
    }
}
