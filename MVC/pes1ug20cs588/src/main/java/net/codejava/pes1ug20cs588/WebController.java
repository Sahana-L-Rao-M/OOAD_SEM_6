/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.codejava.pes1ug20cs588;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.thymeleaf.standard.expression.Each;

import com.google.gson.Gson;

/**
 * 
 */


@Controller
public class WebController {

    /**
     * @param model
     * @param fname
     * @param lname
     * @param phno
     * @param ssn
     * @param address
     * @return
     */
    @PostMapping("/result")
    public String PersonInfo(Model model, String fname, String lname, String phno,String ssn,String address)
    {
                System.out.println("Inserting data...");
                Information e = new Information(fname,lname,phno,ssn,address);
                
                
                // Database
                MongoClient client = MongoClients.create();

               MongoDatabase db = client.getDatabase("Pinfo");
               final MongoCollection col = db.getCollection("Pinfo");
              
               Document profile = (Document)col.find(new Document("fname", fname).append("lname",lname).append("phno",phno).append("ssn",ssn).append("address",address)).first(); 
               
               if(profile != null)
               {
                   String k = profile.toJson();
                   Gson gson = new Gson();
                   Information cache = gson.fromJson(k, Information.class);
                   model.addAttribute("fname", "First Name: "+cache.fname );
                   model.addAttribute("lname"," Last Name: " + cache.lname);
                   model.addAttribute( "phno", "Phone Number: "+ cache.phno);
                   model.addAttribute("ssn", "SSN: "+ cache.ssn);
                   model.addAttribute("address", "Address: "+ cache.address);
                   System.out.println("From DB, result:"+ cache.fname + " " + cache.lname+ " "+ cache.phno+ " "+ cache.ssn+ " "+ cache.address);
                   return "result.html";
               }
               String res = e.fname+" "+e.lname+" "+e.phno+" "+e.ssn+" "+e.address;
               System.out.println(res);
               Document sampleDoc = new Document("fname", fname).append("lname",lname).append("phno", phno).append("ssn",ssn).append("address",address);
               col.insertOne(sampleDoc);
               model.addAttribute("fname", "First Name: "+fname );
               model.addAttribute("lname"," Last Name: " +lname);
               model.addAttribute( "phno", "Phone Number: "+phno);
               model.addAttribute("ssn", "SSN: "+ ssn);
               model.addAttribute("address", "Address: "+ address);
               System.out.println("From DB, result:"+ fname + " " + lname+ " "+ phno+ " "+ ssn+ " "+ address);
               return "result.html";
    }
}
