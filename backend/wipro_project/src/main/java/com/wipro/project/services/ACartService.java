package com.wipro.project.services;

import com.wipro.project.models.ACart;
import com.wipro.project.repos.ACartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ACartService {

    @Autowired
    private ACartRepo br;

    public ACart create(ACart book) {
        return br.save(book);
    }

    public List<ACart> read() {
        return (List<ACart>) br.findAll();
    }

    public ACart read(Integer id) {
        Optional<ACart> temp = br.findById(id);
        ACart b=null;
        if(temp.isPresent())
        {
            b=temp.get();
        }
        return b;
    }

    public ACart update(ACart book) {
        ACart b=read(book.getId());
        if(b!=null)
        {
            br.save(book);
        }
        return b;
    }

    public ACart delete(Integer id) {
        ACart b=read(id);
        if(b!=null)
        {
            br.delete(b);
            System.out.println("deleted");
        }
        return b;
    }



    public void updateQty(int id,int quantity) {
        ACart c=br.findById(id).get();
        c.setQuantity(quantity);
        br.save(c);
    }
}
