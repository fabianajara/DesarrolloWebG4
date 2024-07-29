
package com.desarrollowebG4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccommodationsController {

    @GetMapping("/Accommodations")
    public String getAccommodationsPage() {
        return "Accommodations";
    }
}
