package dao;

import connection.connectDB;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.BaseModele;

public class Generaliser 
{
    public Integer getId(String sequence) throws Exception
    {
        Integer id=0;
        Connection connect=null;
        try
        {
            connect=connectDB.getCon();
            connect.setAutoCommit(false);
            Statement statement=connect.createStatement();
            String sql="SELECT nextval('"+sequence+"')";
            ResultSet rs = statement.executeQuery(sql);
            rs.next();
            id = Integer.parseInt(rs.getString(1));
            connect.commit();
            connect.close();
        }
        catch(SQLException e)
        {
            if(connect!=null)
            {
                try
                {
                    connect.rollback();
                    connect.close();
                }
                catch(SQLException ex){}
            }
        }
        return id;
    }

    public Integer save(BaseModele basemodel) throws Exception
    {
        
        Connection connection=null;
        try
        {
            connection=connectDB.getCon();
            connection.setAutoCommit(false);
            Integer id = save(connection,basemodel);
            connection.commit();
            return id;
        }
        catch(SQLException e)
        {
            if(connection!=null)
                connection.rollback();
            throw e;
        }
        finally
        {
            if(connection!=null){
                connection.close();
            }
        }
    }

    public Integer save(Connection connection,BaseModele basemodel) throws Exception
    {
        PreparedStatement state =null;
        try 
        {
            String table = basemodel.getClass().getName().substring(6).toLowerCase();
            String[] keys=FonctionDAO.recupererAttribut(basemodel);
            String fields=FonctionDAO.recupererStringAttribut(basemodel);
            String sequence=table.toLowerCase()+"_id_seq";
            Integer id = getId(sequence);
            basemodel.setId(id);
            String query = "insert into " + table + "("+ fields+") values (";
            for(String k : keys)
            {
                query+="?,";
            }
            query=query.substring(0, query.length()-1);
            query+=")";
            System.out.println("Ito"+query);
            int i=1;
            state = connection.prepareStatement(query);
            Method[] values=FonctionDAO.getMethodes(basemodel);
            for(String k : keys)
            {
                if(values[i-1].invoke(basemodel).getClass().equals(java.util.Date.class))
                {
                    java.sql.Date date = new java.sql.Date(((java.util.Date)values[i-1].invoke(basemodel)).getTime());
                    state.setObject(i, date);
                }
                else{
                    
                    state.setObject(i, values[i-1].invoke(basemodel));
                }      
                i++;
            }
            state.execute();
            return id;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            throw e;
        }
        finally
        {
            if(state!=null)
                state.close();
        }
    }
     
    public void update(BaseModele basemodel) throws Exception 
    {
        Connection connection=null;
        try
        {
            connection=connectDB.getCon();
            connection.setAutoCommit(false);
            update(connection,basemodel);
            connection.commit();
        }
        catch(SQLException e)
        {
            if(connection!=null)   
                connection.rollback();
            throw e;
        }
        finally
        {
            if(connection!=null){
                connection.close();
            }
        }
    }
    public void update(Connection connection,BaseModele basemodel) throws Exception
    {
        PreparedStatement state =null;
        try 
        {
            String[] keys=FonctionDAO.recupererAttribut(basemodel);
            Method [] values=FonctionDAO.getMethodes(basemodel);
            String table = basemodel.getClass().getName().substring(6).toLowerCase();
            int i=1;

            String query = "update " + table + " set ";

            for(String k : keys)
            {
                query+=k+"=?,";
            }
            query=query.substring(0,query.length()-1);
            query+=" where id="+basemodel.getId();
            System.out.println("Ito"+query);
            state = connection.prepareStatement(query);

            for(String k : keys)
            {
                if(values[i-1].invoke(basemodel).getClass().equals(java.util.Date.class))
                {
                    java.sql.Date date = new java.sql.Date(((java.util.Date)values[i-1].invoke(basemodel)).getTime());
                    state.setObject(i, date);
                }
                else
                    state.setObject(i, values[i-1].invoke(basemodel));
                i++;
            }
            state.execute();
        } 

        catch(SQLException e)
        {
            throw e;
        }
        finally
        {
            if(state!=null)
                state.close();
        }
    }
    public void delete(BaseModele basemodel) throws Exception
    {
        Connection connection=null;
        try
        {
            connection=connectDB.getCon();
            connection.setAutoCommit(false);
            delete(connection,basemodel);
            connection.commit();
        }
        catch(SQLException e)
        {
            if(connection!=null)   
                connection.rollback();
            throw e;
        }
        finally
        {
            if(connection!=null){
                connection.close();
            }
        }
    }
    public void delete(Connection connection,BaseModele basemodel) throws Exception
    {
        PreparedStatement state =null;
        try 
        {
            String table = basemodel.getClass().getName().substring(6).toLowerCase();
            String query="";
            if(basemodel.getId()!=0)
                query = "delete from " + table + " where id="+basemodel.getId();
            else
                query = "delete from " + table +" where 1<2";

            state = connection.prepareStatement(query);
            state.execute();
        } 

        catch(SQLException e)
        {
            throw e;
        }
        finally
        {
            if(state!=null)
                state.close();
        }
    }
    
    public void deleteAll(BaseModele basemodel) throws Exception 
    {
        Connection connection=null;
        try
        {
            connection=connectDB.getCon();
            connection.setAutoCommit(false);
            deleteAll(connection,basemodel);
            connection.commit();
        }
        catch(SQLException e)
        {
            if(connection!=null)   
                connection.rollback();
            throw e;
        }
        finally
        {
            if(connection!=null){
                connection.close();
            }
        }
    }
    public void deleteAll(Connection connection,BaseModele base) throws Exception
    {
        delete(connection,base);
    }
    public List<BaseModele> find(Connection connection, BaseModele basemodel,String condition,Integer limit, Integer offset) throws Exception 
    {
        List<BaseModele> liste = new ArrayList<BaseModele>();
        try
        {
            connection=connectDB.getCon();
            connection.setAutoCommit(false);
            liste = find(basemodel, condition, limit, offset);
            connection.commit();
        }
        catch(SQLException e)
        {
            if(connection!=null)   
                connection.rollback();
            throw e;
        }
        finally
        {
            if(connection!=null){
                connection.close();
            }
        }
        return liste;
    }
    public List<BaseModele> find1(Connection connection, BaseModele basemodel,String condition,Integer limit, Integer offset) throws Exception 
    {
        return find(basemodel, condition, limit, offset);
    }
    public List<BaseModele> find(BaseModele conditionmodel,String condition,Integer limit, Integer offset) throws Exception
    {
        List<BaseModele> result = new ArrayList<BaseModele>();
        Connection connection=null;
        PreparedStatement state =null;
        ResultSet rs = null;
        int u=0;
        try 
        {
            connection=connectDB.getCon();
            connection.setAutoCommit(false);
            String fields=FonctionDAO.recupererStringAttribut(conditionmodel);
            String table = conditionmodel.getClass().getName().substring(6).toLowerCase();
            //System.out.println("Ito"+conditionmodel.getClass().getName().substring(6).toLowerCase());

            Method [] setvalues=FonctionDAO.setMethodes(conditionmodel);
            String  [] keys=FonctionDAO.recupererAttribut(conditionmodel);

            String query = "SELECT " + fields + " FROM "+ table;
            if(condition!=null)
                query+=" where "+condition;
            if(limit!=null)
                query+=" limit "+limit;
            if(offset!=null)
                query+=" offset "+offset;
            System.out.println("Ito"+query);
            state = connection.prepareStatement(query);
            rs = state.executeQuery();
            while(rs.next())
            {
                Class classe=conditionmodel.getClass(); 
                BaseModele objet=(BaseModele)classe.newInstance(); 
                for(String key:keys)
                {
                    if(rs.getObject(key).getClass().equals(java.sql.Date.class))
                    {
                        java.util.Date date = new java.util.Date(((java.sql.Date)rs.getObject(key)).getTime());
                        System.out.println("---- "+objet+" -- "+date);
                        setvalues[u].invoke(objet, date);
                    }
                    else{
                        System.out.println("---- "+objet+" -- "+rs.getObject(key));
                        setvalues[u].invoke(objet, rs.getObject(key));
                    }    
                    u++;
                }
                u=0;
                result.add(objet);
            }
            connection.commit();
        }
        catch(Exception e)
        {
            if(connection!=null)   
                connection.rollback();
            throw e;
        }
        finally
        {
            if(rs!=null)
                rs.close();
            if(state!=null)
                state.close();
            if(connection!=null){
                connection.close();
            }
        }
        return result;
    }

    public List<BaseModele> findAll(BaseModele base) throws Exception
    {
        return find(base,null,null,null);
    }

    public Integer count(BaseModele base) throws Exception
    {
        return findAll(base).size();
    }

    public Integer count(BaseModele base, String condition) throws Exception
    {
        String req = "SELECT count(*) FROM "+base.getClass().getSimpleName();
        if(condition!=null)
            req += " WHERE "+condition;
        Connection  connection = null;
        PreparedStatement state = null;
        ResultSet rs = null;
        int result;
        try
        {
            connection = connectDB.getCon();
            connection.setAutoCommit(false);
            state = connection.prepareStatement(req);
            rs = state.executeQuery();
            rs.next();
            result = new Integer(rs.getObject(1).toString());
            connection.commit();
        }
        catch(SQLException e)
        {
            if(connection!=null)   
                connection.rollback();
            throw e;
        }
        finally
        {
            if(rs!=null)
                rs.close();
            if(state!=null)
                state.close();
            if(connection!=null){
                connection.close();
            }
        }
        return result;
    }
	
    public void executeRequest(Connection connection, String query) throws Exception
    {
        PreparedStatement state =null;
        try 
        {
            state = connection.prepareStatement(query);
            state.execute();
        } 

        catch(SQLException e)
        {
            throw e;
        }
        finally
        {
            if(state!=null)
                state.close();
        }
    }
}
