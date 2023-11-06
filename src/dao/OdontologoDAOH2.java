package dao;

import model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOH2 implements iDao<Odontologo>{
    private static final Logger logger=Logger.getLogger(OdontologoDAOH2.class);
    private static final String SQL_INSERT="INSERT INTO ODONTOLOGOS (MATRICULA, NOMBRE, APELLIDO) VALUES(?,?,?)";
    private static final String SQL="SELECT * FROM ODONTOLOGOS";
    private static final String SQL_WHERE="SELECT * FROM ODONTOLOGOS WHERE ID=?";

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        logger.info("Iniciando guardado: ");
        Connection connection=null;
        try {
            connection=BD.getConnection();
            PreparedStatement ps=connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,odontologo.getNumeroMatricula());
            ps.setString(2,odontologo.getNombre());
            ps.setString(3, odontologo.getApellido());
            ps.execute();
            ResultSet rs=ps.getGeneratedKeys();
            while (rs.next()){
                odontologo.setId(rs.getInt(1));
            }
        }catch (Exception e){
            logger.error(e.getMessage());
        }finally {
            try {
                connection.close();
            }catch (Exception ex){
                logger.error("Ocurrio un error: " + ex.getMessage());
            }
        }
        logger.info("Guardado con exito.");

        return odontologo;
    }

    @Override
    public Odontologo buscar(Integer id) {
        logger.info("Iniciando buscar por el id número: " + id);
        Connection connection=null;
        Odontologo odontologo=null;
        try {
            connection=BD.getConnection();
            PreparedStatement ps=connection.prepareStatement(SQL_WHERE);
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                Integer idEstudiante=rs.getInt(1);
                int matricula=rs.getInt(2);
                String nombre=rs.getString(3);
                String apellido=rs.getString(4);
                odontologo=new Odontologo(idEstudiante,matricula,nombre,apellido);
            }
            logger.info("terminado el buscar");

        }catch (Exception e){
            logger.error(e.getMessage());
        }finally {
            try {
                connection.close();
            }catch (Exception ex){
                logger.error(ex.getMessage());
            }
        }


        return odontologo;
    }

    @Override
    public void eliminar(Integer id) {
        logger.info("Iniciando proceso de eliminado al id número: " + id);
        Connection connection=null;
        try {
            connection=BD.getConnection();
            PreparedStatement ps=connection.prepareStatement("DELETE FROM ODONTOLOGOS WHERE ID=?");
            ps.setInt(1, id);
            ps.executeUpdate();

            logger.info("Odontologo eliminado");

        }catch (Exception e){
            logger.warn("Ocurrio un error: " + e.getMessage());
        }finally {
            try {
                connection.close();
            }catch (Exception ex){
                logger.warn("Ocurrio un eror: " + ex.getMessage());
            }
        }

    }

    @Override
    public void actualizar(Odontologo odontologo) {
        logger.info("Iniciando actualización");
        Connection connection=null;
        try {
            connection=BD.getConnection();
            PreparedStatement ps=connection.prepareStatement("UPDATE ODONTOLOGOS SET MATRICULA=?,NOMBRE=?,APELLIDO=? WHERE ID=?");
            ps.setInt(1,odontologo.getNumeroMatricula());
            ps.setString(2,odontologo.getNombre());
            ps.setString(3,odontologo.getApellido());
            ps.setInt(4,odontologo.getId());
            int roswAffected=ps.executeUpdate();
            if (roswAffected>0){
                logger.info("Se actualizó el odontólogo con ID: " + odontologo.getId());
            }else {
                logger.info("No se encontró el odontólogo con ID: " + odontologo.getId());
            }
        }catch (Exception e){
            logger.warn(e.getMessage());
        }finally {
            try {
                if(connection !=null){
                    connection.close();
                }
            }catch (Exception ex){
                logger.error(ex.getMessage());
            }
        }

    }

    @Override
    public List<Odontologo> buscarTodos() {
        logger.info("Buscando lista Odontologos");
        Connection connection=null;
        List<Odontologo> odontologoList=new ArrayList<>();
        try {
            connection=BD.getConnection();
            PreparedStatement ps=connection.prepareStatement(SQL);
            ResultSet rs=ps.executeQuery();

            while (rs.next()){
                Odontologo odontologo = new Odontologo(rs.getInt(1),rs.getInt(2),rs.getString(3), rs.getString(4));
                odontologoList.add(odontologo);
             }
            logger.info("Lista encontrada: ");
            for (Odontologo o: odontologoList){
                logger.info("id: " + o.getId()+ " " + " "+ "matricula: " +o.getNumeroMatricula() + " " +"nombre: " + o.getNombre() + " "+"apellido: " + o.getApellido());
            }

        }catch (Exception e){
            logger.error("Ocurrio un error: " + e.getMessage());
        }finally {
            try {
                connection.close();
            }catch (Exception ex){
                logger.error("Ocurrio un error: " + ex.getMessage());
            }
        }
        logger.info("Lista mostrada");
        return odontologoList;
    }
}