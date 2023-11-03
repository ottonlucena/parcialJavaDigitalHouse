package test;


import dao.OdontologoDAOH2;
import model.Odontologo;
import org.junit.jupiter.api.Test;
import service.OdontologoService;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class OdontologoTest {
    private OdontologoService odontologoService;

    @Test
    void probar(){
        odontologoService=new OdontologoService(new OdontologoDAOH2());
        Odontologo odontologo=new Odontologo(1,1234,"OTTON", "LUCENA");
        Odontologo odontologoPrueba=odontologoService.guardarOdontolog(odontologo);
        List<Odontologo> listaOdontologos=odontologoService.odontologoList();
        System.out.println(listaOdontologos);
        assertEquals(odontologo.getId(),odontologoPrueba.getId(), "Los id no coinciden");


    }


}
