import dao.BD;
import dao.OdontologoDAOH2;
import dao.OdontologoDAOMemoria;
import model.Domicilio;
import model.Odontologo;
import model.Paciente;
import service.OdontologoService;
import service.PacienteService;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Cliente {
    public static void main(String[] args) {
        //Creamos la tabla
        BD.crearTabla();
        //Instanciamos un nuevo Paciente
        //Paciente paciente= new Paciente("Carlos","Maslatone","122334", LocalDate.of(2023,10,03),new Domicilio("Calle 1",2,"La Rioja","La Rioja"));
        //PacienteService pacienteService= new PacienteService();
        //pacienteService.guardarPaciente(paciente);

        //Instanciamos un nuevo Odontologo
        Odontologo odontologo1=new Odontologo(123,"Otton","Lucena");
        Odontologo odontologo2=new Odontologo(123,"Jose","Lucena");
        OdontologoService odontologoService= new OdontologoService(new OdontologoDAOH2());
        //OdontologoService odontologoService2= new OdontologoService(new OdontologoDAOMemoria());
        //odontologoService2.guardarOdontolog(odontologo1);
        //odontologoService2.guardarOdontolog(odontologo2);
        odontologoService.guardarOdontolog(odontologo1);
        odontologoService.guardarOdontolog(odontologo2);
        //odontologoService.odontologoList();
        System.out.println(odontologoService.buscarOdontologo(4));
        odontologoService.odontologoList();

        odontologoService.eliminarOdontologo(3);
        odontologoService.odontologoList();
        //System.out.println(odontologoService2.odontologoList());;
        odontologo1=new Odontologo(2,123,"Jese", "pppp");
        odontologoService.actualizarOdontologo(odontologo1);
        odontologoService.odontologoList();


       
    }
}
