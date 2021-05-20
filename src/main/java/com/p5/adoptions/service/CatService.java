package com.p5.adoptions.service;

import antlr.StringUtils;
import com.p5.adoptions.model.CatDTO;
import com.p5.adoptions.model.ListDTO;
import com.p5.adoptions.model.adapters.CatAdapter;
import com.p5.adoptions.repository.cats.Cat;
import com.p5.adoptions.repository.cats.CatRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CatService {

    private final CatRepository catRepository;
    private final CatAdapter catAdapter = new CatAdapter();

    public CatService(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    public void addCat(CatDTO catDTO){
        if (catDTO.getName() == null && catDTO.getPhotoUrl() == null){
            throw new RuntimeException("Cat must have a name and a photo!");
        }
 
       catRepository.save(CatAdapter.fromDto(catDTO));
    }

    public ListDTO<CatDTO> findAll(){

        List<CatDTO> cats = catAdapter.toListDto(catRepository.findAll().stream().filter(cat -> cat.getId() != 2).collect(Collectors.toList()));
        long totalCount =  catRepository.count();
        return new ListDTO<CatDTO>(Math.toIntExact(totalCount), cats);
    }

    public CatDTO findCat (String name){
        if (name==null || name.equals("")){
            throw new RuntimeException("Must specify name");
        }
       // CatAdapter adapter = new CatAdapter();
        return CatAdapter.toDto(catRepository.findCatByName(name));
    }
}
