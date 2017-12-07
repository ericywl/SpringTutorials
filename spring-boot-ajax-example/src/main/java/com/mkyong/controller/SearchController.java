package com.mkyong.controller;

import com.mkyong.model.AjaxResponseBody;
import com.mkyong.model.SearchCriteria;
import com.mkyong.model.Slot;
import com.mkyong.model.User;
import com.mkyong.services.SlotService;
import com.mkyong.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SearchController {

    SlotService slotService;

    @Autowired
    public void setUserService(SlotService slotService) {
        this.slotService = slotService;
    }

    @PostMapping("/api/search")
    public ResponseEntity<?> getSearchResultViaAjax(@Valid @RequestBody SearchCriteria search, Errors errors) {

        AjaxResponseBody result = new AjaxResponseBody();

        //If error, just return a 400 bad request, along with the error message
        if (errors.hasErrors()) {

            result.setMsg(errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));
            return ResponseEntity.badRequest().body(result);

        }

        List<Slot> slots = slotService.findByProfAlias(search.getUsername());
        if (slots.isEmpty()) {
            result.setMsg("no user found!");
        } else {
            result.setMsg("success");
        }

        result.setResult(slots);

        return ResponseEntity.ok(result);
    }

}
