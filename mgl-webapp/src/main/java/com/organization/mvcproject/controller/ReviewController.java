package com.organization.mvcproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.organization.mvcproject.model.ReviewImpl;

@Controller
public class ReviewController {
    
    @GetMapping("review")
    public ModelAndView review() {
        return new ModelAndView("reviewCreatePage", "command", new ReviewImpl());
    }

    @PostMapping("addReview")
    public ModelAndView addReview(ReviewImpl review, ModelMap model) {
        if(review.getAuthor().equals("")) {
            review.setAuthor("anonymous");
        }
        return new ModelAndView("reviewDetailPage", "submittedReview", review);
    }

}
