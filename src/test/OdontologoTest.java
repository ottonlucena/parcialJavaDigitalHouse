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
    void testGuardar(){
        //Test para el método guardar
        odontologoService=new OdontologoService(new OdontologoDAOH2());
        Odontologo odontologo=new Odontologo(123,"Otton","Lucena");
        Odontologo result= odontologoService.guardarOdontolog(odontologo);
        assertNotNull(result); //Verificamos que el objeto no venga nulo.
        assertEquals(123,result.getNumeroMatricula()); //Comparamos el resultado escrito con el esperado.
        assertEquals("Otton",result.getNombre());
        assertEquals("Lucena",result.getApellido());
        System.out.println(odontologoService.odontologoList());
    }

    @Test
    void testBuscarid(){
        odontologoService=new OdontologoService(new OdontologoDAOH2());
        Odontologo result=odontologoService.buscarOdontologo(1);
        assertNotNull(result);
        assertEquals(1,result.getId());
    }

    @Test
    void testEliminar(){
        odontologoService=new OdontologoService(new OdontologoDAOH2());
        odontologoService.eliminarOdontologo(2);
        Odontologo result=odontologoService.buscarOdontologo(2);
        assertNull(result);

    }

    @Test
    void testActualizar(){
        odontologoService=new OdontologoService(new OdontologoDAOH2());
        Odontologo odontologo3=new Odontologo(3,456,"Otton","Lucena");
        odontologoService.actualizarOdontologo(odontologo3);
        Odontologo result=odontologoService.buscarOdontologo(3);
        assertEquals(3,result.getId());
        assertEquals("Otton",result.getNombre());
        assertEquals("Lucena",result.getApellido());
    }

    @Test
    void testBuscarTodos(){
        odontologoService=new OdontologoService(new OdontologoDAOH2());
        List<Odontologo> result=odontologoService.odontologoList();
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

}
