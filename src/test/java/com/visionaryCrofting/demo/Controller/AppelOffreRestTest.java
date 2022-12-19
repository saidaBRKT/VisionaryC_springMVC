package com.visionaryCrofting.demo.Controller;

import com.visionaryCrofting.demo.entity.AppelOffre;
import com.visionaryCrofting.demo.entity.Status;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AppelOffreRestTest {
@Autowired AppelOffreRest aoRest;
@Test
    void save() throws Exception {
    AppelOffre ao = new AppelOffre(12L,"ref1", "ref1", Status.close, 13);
    AppelOffre result = aoRest.save(ao);
    Assertions.assertSame(ao,result);
    }
}