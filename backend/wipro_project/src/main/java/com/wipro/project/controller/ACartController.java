package com.wipro.project.controller;


import com.wipro.project.dtos.Response;
import com.wipro.project.models.ACart;
import com.wipro.project.services.ACartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("ACart")
@CrossOrigin(origins = {"http://localhost:4200"})
public class ACartController {

    @Autowired
    private ACartService bs;


    @PostMapping
    public ACart addBook1(@RequestParam("name") String name, @RequestParam("price") Float price, @RequestParam("quantity") Integer quantity) throws IOException {

        ACart book = new ACart(name, price ,quantity);
        return bs.create(book);
    }

    @GetMapping
    public List<ACart> getAllBook() {
        return bs.read();
    }

    @GetMapping("/{id}")
    public ACart findBookById(@PathVariable("id") Integer id) {
        return bs.read(id);
    }

    @PutMapping("/update={id}")
    public ACart updateBook(@RequestBody ACart book) {
        return bs.update(book);
    }

    @DeleteMapping("/delete/{id}")
    public ACart deleteBook(@PathVariable("id") Integer id) {
        return bs.delete(id);
    }


    @GetMapping("updateqty")
    public ResponseEntity<?> updateQty(int id, int quantity){
        bs.updateQty(id, quantity);
        return Response.success("quantity updated");
    }
}
