package mx.edu.utez.kofexam.model.character;

import mx.edu.utez.kofexam.Repository;
import mx.edu.utez.kofexam.model.fightType.BeanFightType;
import mx.edu.utez.kofexam.model.magic.BeanMagic;
import mx.edu.utez.kofexam.utils.MySQLConnection;
import mx.edu.utez.kofexam.utils.Response;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoCharacter implements Repository<BeanCharacter> {
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    Response response = new Response();
    MySQLConnection mySQLConnection = new MySQLConnection();

    @Override
    public List<BeanCharacter> getAllCharacters() {
        List<BeanCharacter> characters = new ArrayList<>();
        BeanCharacter character = null;
        BeanMagic magic = null;
        BeanFightType fightType = null;
        try{
            conn = mySQLConnection.getConnection();
            ps = conn.prepareStatement("SELECT * FROM personaje INNER JOIN magia ON personaje.magia_id = magia.id INNER JOIN tipo_lucha ON personaje.tipo_lucha_id = tipo_lucha.id");
            rs = ps.executeQuery();
            while (rs.next()){
                character = new BeanCharacter();
                magic = new BeanMagic();
                fightType = new BeanFightType();
                character.setName(rs.getString("name"));
                character.setLastname(rs.getString("lastname"));
                character.setBirthday(rs.getDate("birthday"));
                character.setHasMagic(rs.getShort("utiliza_magia"));
                character.setHeight(rs.getDouble("estatura"));
                character.setWeight(rs.getDouble("peso"));
                character.setTeam(rs.getInt("equipo"));
                magic.setMagicName(rs.getString("magia.name"));
                character.setMagicId(magic);
                fightType.setFightName(rs.getString("tipo_lucha.name"));
                character.setFightTypeId(fightType);
                characters.add(character);
            }
        }catch(SQLException e){
            Logger.getLogger(DaoCharacter.class.getName()).log(Level.SEVERE, "ERROR -> getAllCharacters: " + e.getMessage());
        }finally {
            mySQLConnection.close(conn, ps, rs);
        }
        return characters;
    }

    @Override
    public Response<BeanCharacter> getById(Long id) {
        BeanCharacter character = null;
        BeanMagic magic = null;
        BeanFightType fightType = null;
        try{
            conn = mySQLConnection.getConnection();
            ps = conn.prepareStatement("SELECT * FROM personaje INNER JOIN magia ON personaje.magia_id = magia.id INNER JOIN tipo_lucha ON personaje.tipo_lucha_id = tipo_lucha.id WHERE personaje.id = ?");
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                character = new BeanCharacter();
                magic = new BeanMagic();
                fightType = new BeanFightType();
                character.setName(rs.getString("name"));
                character.setLastname(rs.getString("lastname"));
                character.setBirthday(rs.getDate("birthday"));
                character.setHasMagic(rs.getShort("utiliza_magia"));
                character.setHeight(rs.getDouble("estatura"));
                character.setWeight(rs.getDouble("peso"));
                character.setTeam(rs.getInt("equipo"));
                magic.setMagicName(rs.getString("magia.name"));
                character.setMagicId(magic);
                fightType.setFightName(rs.getString("tipo_lucha.name"));
                character.setFightTypeId(fightType);
                response.setError(false);
                response.setStatus(200);
                response.setMessage("Ok");
                response.setData(character);
            }else {
                response.setError(true);
                response.setStatus(400);
                response.setMessage("Nothing found");
                response.setData(null);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoCharacter.class.getName()).log(Level.SEVERE, "ERROR -> getById: " + e.getMessage());
        }finally {
            mySQLConnection.close(conn, ps, rs);
        }
        return response;
    }

    @Override
    public Response<BeanCharacter> save(BeanCharacter character) {
        try{
            conn = mySQLConnection.getConnection();
            ps = conn.prepareStatement("INSERT INTO personaje (name, lastname, birthday, utiliza_magia, estatura, peso, equipo, magia_id, tipo_lucha_id)" +
                    "VALUES (?,?,?,?,?,?,?,?,?)");
            ps.setString(1, character.getName());
            ps.setString(2, character.getLastname());
            ps.setDate(3, character.getBirthday());
            ps.setShort(4, character.getHasMagic());
            ps.setDouble(5, character.getHeight());
            ps.setDouble(6, character.getWeight());
            ps.setInt(7, character.getTeam());
            ps.setLong(8, character.getMagicId().getMagicId());
            ps.setLong(9, character.getFightTypeId().getFightId());

            if (ps.executeUpdate() == 1) {
                response.setError(false);
                response.setStatus(200);
                response.setMessage("Ok");
                response.setData(character);
            }else {
                response.setError(true);
                response.setStatus(400);
                response.setMessage("Nothing found");
                response.setData(null);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoCharacter.class.getName()).log(Level.SEVERE, "ERROR -> save: " + e.getMessage());
        }finally {
            mySQLConnection.close(conn, ps, rs);
        }
        return response;
    }

    @Override
    public Response<BeanCharacter> update(BeanCharacter character) {
        try{
            conn = mySQLConnection.getConnection();
            ps = conn.prepareStatement("UPDATE personaje SET name=?, lastname=?, birthday=?, utiliza_magia=?, estatura=?, peso=?, equipo=?, magia_id=?, tipo_lucha_id=? WHERE personaje.id = ?");
            ps.setString(1, character.getName());
            ps.setString(2, character.getLastname());
            ps.setDate(3, character.getBirthday());
            ps.setShort(4, character.getHasMagic());
            ps.setDouble(5, character.getHeight());
            ps.setDouble(6, character.getWeight());
            ps.setInt(7, character.getTeam());
            ps.setLong(8, character.getMagicId().getMagicId());
            ps.setLong(9, character.getFightTypeId().getFightId());
            ps.setLong(10, character.getId());

            if (ps.executeUpdate() == 1) {
                response.setError(false);
                response.setStatus(200);
                response.setMessage("Ok");
                response.setData(character);
            }else {
                response.setError(true);
                response.setStatus(400);
                response.setMessage("Nothing found");
                response.setData(null);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoCharacter.class.getName()).log(Level.SEVERE, "ERROR -> update: " + e.getMessage());
        }finally {
            mySQLConnection.close(conn, ps, rs);
        }
        return response;
    }
}
