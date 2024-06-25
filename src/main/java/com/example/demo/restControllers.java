package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class restControllers {
    @GetMapping("/")
    public String runThis(){
        return "Hello World";
    }

    @GetMapping("/add")
    public int addition(@RequestParam int a, @RequestParam int b){
        return a+b;
    }

    private List<Integer> arrayList = new ArrayList<>();

    @GetMapping("/addElement")
    public String addElement(@RequestParam int element) {
        System.out.println("number received = " + element + " by sout ");
        arrayList.add(element);
        return "number has been added by return type" + element;
    }

    @GetMapping("/searchElement")
    public boolean searchElement(@RequestParam int element) {
        return arrayList.contains(element);
    }

    @GetMapping("/printArray")
    public List<Integer> getArray() {
        System.out.println("printed array list");
        return new ArrayList<>(arrayList);
    }

    @GetMapping("/addMultipleElements")
    public String addMultipleElements(@RequestBody List<Integer> elements) {
        System.out.println("number received = " + elements + " by sout ");
        for (Integer element : elements) {
            arrayList.add(element);
        }
        return "added multiple elements" + elements;
    }
}
