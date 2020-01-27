/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import model.BaseModele;

/**
 *
 * @author OTME
 */
public class FonctionDAO {
	
	public static String firstUpper(String str) {
        return str.substring(0,1).toUpperCase() + str.substring(1);
    }
	
    public static Field[] recupererField(BaseModele base)
    {        
        Object object = (Object)base;
        Class classe=object.getClass();
        Field[] fields=classe.getDeclaredFields();
        return fields;		
    }

    public static String[] recupererAttribut(BaseModele base) throws Exception
    {
        Object lo = (Object)base;
        Class classefille=lo.getClass();
        Class classemere=classefille.getSuperclass();
        Field[] attributFille=classefille.getDeclaredFields();
        Field[] attributMere=classemere.getDeclaredFields();
        String[] listeattribut=new String[attributFille.length+attributMere.length];
        Field[] attributs=new Field[attributFille.length+attributMere.length];
        try{
             for(int i=0;i<(attributMere.length+attributFille.length);i++){
                for(int j=0;j<attributMere.length;j++){
                    attributs[i]=attributMere[j];
                    listeattribut[i]=attributs[i].getName();
                    i++;
                }
                for(int a=0;a<attributFille.length;a++){
                    attributs[i]=attributFille[a];
                    listeattribut[i]=attributs[i].getName();
                    i++;
                }
            }
        }catch(Exception ex){
            throw ex;
        }
        return listeattribut;
    }

    public static String recupererStringAttribut(BaseModele base) throws Exception
    {
        String[] fields=recupererAttribut(base);
        String field="";
        try {
            for(String s:fields)
            {
                field+=s+",";
            }
            field=field.substring(0, field.length()-1);
        } catch (Exception e) {
            throw e;
        }
        return field;
    }

    public static Method[] getMethodes(BaseModele base) throws Exception
    {
        String[] field=recupererAttribut(base);
        Method[] m=new Method[field.length];
        Class classe=base.getClass();
        try{
            
            for(int i=0;i<field.length;i++)
            {
                m[i]=classe.getMethod("get"+firstUpper(field[i]));
            }
       
        }catch(Exception ex){
            throw ex;
        }
         return m;
        
    }

    public static Method[] setMethodes(BaseModele base) throws Exception
    {
        String[] field=recupererAttribut(base);
        Method[] m=new Method[field.length];
        Class classe=base.getClass();
        try{
            for(int i=0;i<field.length;i++){
                Method getmethod=getMethodes(base)[i];
                m[i]=classe.getMethod("set"+firstUpper(field[i]),getmethod.getReturnType());
            }
        }catch(Exception ex){
            throw ex;
        }
        return m;
    }
}
