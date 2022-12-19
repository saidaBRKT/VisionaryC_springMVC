package com.visionaryCrofting.demo.service.implementation;

import com.visionaryCrofting.demo.entity.Product;
import com.visionaryCrofting.demo.Repositories.ProductRepository;
import com.visionaryCrofting.demo.service.ProductService;
import com.visionaryCrofting.demo.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductServiceImp implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    StockService stockService;

    @Override
    public Page<Product> findByNameContains(String mc, Pageable pageable) {
        return productRepository.findByNameContains(mc,pageable);
    }
    @Override
    public Optional<Product> getById(Long id) {
        return productRepository.findById(id);
    }
    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public int count() {
        return productRepository.findAll().size();
    }

    @Override
    public Product save(Product product) {
//        if (product.getCategory()== null || product.getName()==null ||
//        product.getDescreption()==null || product.getQuantity()<=0 ) {
//            throw new IllegalStateException("Toutes les données sont obligatoires");
//
//        }
//        else {

//            Pattern pattRef = Pattern.compile("^[A-Za-z]{1,5}[0-9]{5,20}$");
//            Pattern pattNom = Pattern.compile("^[A-Za-z\\s]{5,20}$");
////            Pattern pattDesc = Pattern.compile("^[A-Za-z\\s]$");
//            Matcher matcher1 = pattNom.matcher(product.getNom());
//            Matcher matcher2 = pattDesc.matcher(product.getDescreption());
//            if(!matcher1.matches() && matcher2.matches()) {
//                throw new IllegalStateException("Le nom est non valide");
//            }else if(!matcher1.matches() && matcher2.matches()) {
//                throw new IllegalStateException("Le nom est non valide");
//            }else if(!matcher2.matches()){
//                throw new IllegalStateException("La description  est non valide");
//            }
//            else{

                return productRepository.save(product);

//            }

//        }
    }
//
////    @Override
////    public Product save(Product product) {
////        Product byRef = this.findByRef(product.getRef());
////        if (byRef != null) {
////            return null;
////        }else {
////            if(product.getStock()!=null){
////                Optional<Stock> s = stockRepository.findById(product.getStock().getId());
////                if(s.isPresent()){
////                    product.setStock(s.get());
////                    return productRepository.save(product);
////                }else{
////                    throw new IllegalStateException("stock non trouvée pour l'id"+product.getStock().getId());
////                }
////            }else {
////                throw new IllegalStateException("sotck required");
////            }
////        }
////
////    }
//
//    @Override
//    public Product update(Product t) {
//        Product byRef = this.findByRef(t.getRef());
//        if (byRef == null){
//            throw new IllegalStateException("product not found");
//        }else {
//            byRef.setRef(t.getRef());
//            byRef.setQuantity(t.getQuantity());
//            byRef.setDescreption(t.getDescreption());
//            byRef.setNom(t.getNom());
//            byRef.setCategory(t.getCategory());
//            Optional<Stock> stock = stockService.getById(t.getStock().getId());
//            if(stock.isPresent()) {
//                byRef.setStock(stock.get());
//            }else{
//                throw new IllegalStateException("stock not found");
//            }
//            return productRepository.save(byRef);
//        }
//    }
    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
//
    @Override
    public Product findByRef(String ref) {
        return productRepository.findByRef(ref);
    }
//
//    @Override
//    @Transactional
//    public int deleteByRef(String ref) {
//        return productRepository.deleteByRef(ref);
//    }
//
//    @Override
//    public Product increaseQte(String ref, int qte) {
//        Product product=productRepository.findByRef(ref);
//        if(product==null){
//            throw new IllegalStateException("Le produit n'existe pas dans le stock");
//        }else {
//            product.setQuantity(product.getQuantity()+qte);
//            productRepository.save(product);
//            return product;
//            }
//    }
//
//    @Override
//    public Product decreaseQte(String ref, int qte) {
//        Product  product=productRepository.findByRef(ref);
//        if(qte>product.getQuantity())
//        {
//            throw new IllegalStateException("La quantité requise est supérieure à la quantité disponible");
//        }else {
//            product.setQuantity(product.getQuantity()-qte);
//            return product;
//        }
//    }


}
