package dao;

import model.Domicilio;
import model.Paciente;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.List;

public class PacienteDAOH2 implements iDao<Paciente>{
    private static final Logger logger= Logger.getLogger(PacienteDAOH2.class);
    private static  final String SQL_INSERT="INSERT INTO PACIENTES (NOMBRE, APELLIDO, CEDULA, FECHA_INGRESO, DOMICILIO_ID) VALUES(?,?,?,?,?)";
    @Override
    public Paciente guardar(Paciente paciente) {
        logger.info("guardando paciente");
        Connection connection= null;
        try{
            connection= BD.getConnection(); //obtengo la conexion
            DomicilioDAOH2 daoAux= new DomicilioDAOH2(); //creo una instancia de dao domicilio para devolver un objeto domicilio
            Domicilio domicilio= daoAux.guardar(paciente.getDomicilio());
            PreparedStatement psInsert= connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            psInsert.setString(1, paciente.getNombre());
            psInsert.setString(2, paciente.getApellido());
            psInsert.setString(3, paciente.getCedula());
            psInsert.setDate(4, Date.valueOf(paciente.getFechaIngreso()));
            psInsert.setInt(5,domicilio.getId());
            psInsert.execute(); //en teoria si hay claves se generan
            ResultSet clave= psInsert.getGeneratedKeys();
            while (clave.next()){
                paciente.setId(clave.getInt(1));
            }
            logger.info(" paciente guardado");


        }catch (Exception e){
            logger.error(e.getMessage());
        }finally {
            try{
                connection.close();
            }catch (SQLException ex){
                logger.error(ex.getMessage());
            }
        }
        return paciente;
    }

    @Override
    public Paciente buscar(Integer id) {
        logger.info("iniciando las operaciones de : ");
        Connection connection= null;
        try{

        }catch (Exception e){
            logger.error(e.getMessage());
        }finally {
            try{
                connection.close();
            }catch (SQLException ex){
                logger.error(ex.getMessage());
            }
        }
        return null;
    }

    @Override
    public void eliminar(Integer id) {
        logger.info("iniciando las operaciones de : ");
        Connection connection= null;
        try{

        }catch (Exception e){
            logger.error(e.getMessage());
        }finally {
            try{
                connection.close();
            }catch (SQLException ex){
                logger.error(ex.getMessage());
            }
        }

    }

    @Override
    public void actualizar(Paciente paciente) {
        logger.info("iniciando las operaciones de : ");
        Connection connection= null;
        try{

        }catch (Exception e){
            logger.error(e.getMessage());
        }finally {
            try{
                connection.close();
            }catch (SQLException ex){
                logger.error(ex.getMessage());
            }
        }

    }

    @Override
    public List<Paciente> buscarTodos() {
        logger.info("iniciando las operaciones de : ");
        Connection connection= null;
        try{

        }catch (Exception e){
            logger.error(e.getMessage());
        }finally {
            try{
                connection.close();
            }catch (SQLException ex){
                logger.error(ex.getMessage());
            }
        }
        return null;
    }
}
