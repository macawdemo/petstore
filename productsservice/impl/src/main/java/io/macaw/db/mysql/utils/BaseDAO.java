package io.macaw.db.mysql.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class BaseDAO<D extends BaseDTO> {

	public abstract String getName();
	
    public List<D> findAll() {
        List<D> list = new ArrayList<D>();

        final String FINDALL_QUERY = "SELECT * FROM " + getName();
        DbConnector dbConnector = DbConnector.getInstance();
		Connection conn = dbConnector.getConnection();

        try (Statement stmt = conn.createStatement();
        	ResultSet rs = stmt.executeQuery(FINDALL_QUERY);) {
            while ((rs != null) && rs.next()) {
                D dto = getDto(rs);
                list.add(dto);
            }
            return list;
        } catch (SQLException e) {
        	// TODO log or throw the exception
        } finally {
        	dbConnector.releaseConnection(conn);
        }
        return Collections.emptyList();
    }
    
    public List<D> fetchByQuery(String query) {
        List<D> list = new ArrayList<D>();
        DbConnector dbConnector = DbConnector.getInstance();
		Connection conn = dbConnector.getConnection();
        try (Statement stmt = conn.createStatement();
        	ResultSet rs = stmt.executeQuery(query);) {
            while ((rs != null) && rs.next()) {
                D dto = getDto(rs);
                list.add(dto);
            }
            return list;
        } catch (SQLException e) {
        	// TODO log or throw the exception
        } finally {
        	dbConnector.releaseConnection(conn);
        }
        return Collections.emptyList();
    }

    public abstract D getDto(ResultSet rs);

    public void insert(D dto){
    	final String insertQuery = getInsertQuery(dto);
        DbConnector dbConnector = DbConnector.getInstance();
		Connection conn = dbConnector.getConnection();
        try (Statement stmt = conn.createStatement();) {
        	stmt.executeUpdate(insertQuery);
        } catch (Exception e) {
        	// TODO log or throw the exception
        } finally {
        	dbConnector.releaseConnection(conn);
        }
    }

    public void update(D dto){
    	final String insertQuery = getUpdateQuery(dto);
        DbConnector dbConnector = DbConnector.getInstance();
		Connection conn = dbConnector.getConnection();
        try (Statement stmt = conn.createStatement();) {
        	stmt.executeUpdate(insertQuery);
        } catch (Exception e) {
        	// TODO log or throw the exception
        } finally {
        	dbConnector.releaseConnection(conn);
        }
    }
    
    public D findById(String id){
        final String findByIdQuery = getFindByIdQuery(id);
        DbConnector dbConnector = DbConnector.getInstance();
		Connection conn = dbConnector.getConnection();

        try (Statement stmt = conn.createStatement();
        	ResultSet rs = stmt.executeQuery(findByIdQuery);) {
            if ((rs != null) && rs.next()) {
                return getDto(rs);
            }
        } catch (SQLException e) {
        	// TODO log or throw the exception
        } finally {
            dbConnector.releaseConnection(conn);
        }
        return null;
    }
    
    public void deleteById(String id){
        final String deleteByIdQuery = getDeleteByIdQuery(id);
        DbConnector dbConnector = DbConnector.getInstance();
		Connection conn = dbConnector.getConnection();

        try (Statement stmt = conn.createStatement();) {
        	stmt.executeUpdate(deleteByIdQuery);
        } catch (SQLException e) {
        	// TODO log or throw the exception
        } finally {
            dbConnector.releaseConnection(conn);
        }
    }

	public abstract String getFindByIdQuery(String id);

	public abstract String getDeleteByIdQuery(String id);

	public abstract String getInsertQuery(D dto);

	public abstract String getUpdateQuery(D dto);
}
