package dao;

import model.Odontologo;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOMemoria implements iDao<Odontologo>{
    private static final Logger logger=Logger.getLogger(OdontologoDAOMemoria.class);
    private List<Odontologo> odontologoList;

    public OdontologoDAOMemoria() {
        odontologoList= new ArrayList<>();
    }

    @Override
    public Odontologo guardar(Odontologo odontologo) {

        int id=odontologoList.size()+1;
        Odontologo odontologoGuardado=new Odontologo(id, odontologo.getNumeroMatricula(),odontologo.getNombre(),odontologo.getApellido());
        odontologoList.add(odontologoGuardado);
        logger.info("Se guardo correctamente: " + odontologoGuardado);
        return odontologoGuardado;
    }

    @Override
    public Odontologo buscar(Integer id) {
        return null;
    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public void actualizar(Odontologo odontologo) {

    }

    @Override
    public List<Odontologo> buscarTodos() {

        return odontologoList;
    }
}
