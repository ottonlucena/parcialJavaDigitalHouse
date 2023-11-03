package service;

import dao.iDao;
import model.Odontologo;

import java.util.List;

public class OdontologoService {
    private iDao<Odontologo> odontologoiDao;

    public OdontologoService(iDao<Odontologo> odontologoiDao) {
        this.odontologoiDao = odontologoiDao;
    }

    public Odontologo guardarOdontolog(Odontologo odontologo){
        return odontologoiDao.guardar(odontologo);
    }

    public List<Odontologo> odontologoList(){
        return odontologoiDao.buscarTodos();
    }
    public Odontologo buscarOdontologo(Integer id){
        return odontologoiDao.buscar(id);
    }
    public void eliminarOdontologo(int id){
        odontologoiDao.eliminar(id);
    }
    public void actualizarOdontologo(Odontologo odontologo){
        odontologoiDao.actualizar(odontologo);
    }



}
