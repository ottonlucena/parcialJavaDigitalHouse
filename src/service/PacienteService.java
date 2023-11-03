package service;

import dao.PacienteDAOH2;
import dao.iDao;
import model.Paciente;

public class PacienteService {
    private iDao<Paciente> pacienteiDao;

    public PacienteService() {
        pacienteiDao= new PacienteDAOH2();
    }
    /* public PacienteService(iDao<Paciente> pacienteiDao) {
        this.pacienteiDao = pacienteiDao;
    }*/

    //se generan manuales los metodos
    public Paciente guardarPaciente(Paciente paciente){
        return pacienteiDao.guardar(paciente);
    }
    public Paciente buscarPorId(Integer id){
        return pacienteiDao.buscar(id);
    }


}
