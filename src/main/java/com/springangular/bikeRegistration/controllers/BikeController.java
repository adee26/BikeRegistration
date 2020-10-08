package com.springangular.bikeRegistration.controllers;

import com.springangular.bikeRegistration.entities.Bike;
import com.springangular.bikeRegistration.model.MailModel;
import com.springangular.bikeRegistration.services.BikeService;
import com.springangular.bikeRegistration.services.SendingEmailService;
import freemarker.template.TemplateException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

@RestController
public class BikeController {
    private final BikeService bikeService;
    private final SendingEmailService sendingEmailService;

    public BikeController(BikeService bikeService, SendingEmailService sendingEmailService) {
        this.bikeService = bikeService;
        this.sendingEmailService = sendingEmailService;
    }

    @GetMapping("api/v1/bikes")
    public List<Bike> getAllBikes(){
        return bikeService.findAllBikes();
    }

    @GetMapping("/api/v1/bikes/{id}")
    public Bike getBikeById(@PathVariable("id") long id) {
        return bikeService.getById(id);
    }

    @PostMapping("/api/v1/bikes")
    public void saveBike(@RequestBody Bike bike){
        bikeService.createBike(bike);
    }

    @PostMapping("/api/v2/bikes")
    public void saveBikeAndSendEmail(@RequestBody Bike bike, MailModel mailModel){
        bikeService.createBike(bike);
        try {
            sendingEmailService.sendEmail(mailModel, bike.getName(), bike.getEmail());
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("api/v1/bikes/sellers/{seller}")
    public List<Bike> findBikeBySeller(@PathVariable("seller") String seller){
        return bikeService.findAllBySeller(seller);
    }

}
