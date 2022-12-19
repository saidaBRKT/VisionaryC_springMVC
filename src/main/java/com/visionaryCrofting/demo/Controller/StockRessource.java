package com.visionaryCrofting.demo.Controller;

import com.visionaryCrofting.demo.entity.AppelOffre;
import com.visionaryCrofting.demo.entity.Stock;
import com.visionaryCrofting.demo.Repositories.StockRepository;
import com.visionaryCrofting.demo.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("visionaryCrofting/Stock")
public class StockRessource {

    @Autowired
    private StockService stockService;
    @Autowired
    private  StockRepository stockRepository;
    @PostMapping("/create")
    public Stock saveStock(@RequestBody Stock stock){
        return stockService.save(stock);
    }

    @DeleteMapping ("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
       stockService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public Stock update(@RequestBody Stock stock) {
        return stockService.updateStock(stock);
    }

    // NOT FINISH
    @GetMapping("/search")
    public List<Stock> list(@RequestParam(value = "refProduit",required = false)String refProduct , @RequestParam(value = "status",required = false) String status , @RequestParam(value = "fornisseur",required = false)String fornisseur){
        Specification<AppelOffre> specification = stockService.getSpec(refProduct,status,fornisseur);
        return stockRepository.findAll(specification);
    }
    @GetMapping("/searchByQuery")
    public Collection<AppelOffre> search(@RequestParam(value = "status",required = false)String status , @RequestParam(value = "refProduit",required = false)String refProduit , @RequestParam(value = "fornisseur",required = false)String fornisseur){
        return stockService.search(status,refProduit,fornisseur);
    }
    @GetMapping("/showAll")
    public List<Stock> stockList(){
        return stockService.getAll();
    }
}
