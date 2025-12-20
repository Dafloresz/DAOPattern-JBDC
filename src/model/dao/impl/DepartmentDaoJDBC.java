package model.dao.impl;

import db.DB;
import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DepartmentDaoJDBC implements DepartmentDao {
    private Connection connection;

    public DepartmentDaoJDBC (Connection connection){
        this.connection = connection;
    }

    @Override
    public void insert(Department obj) {

    }

    @Override
    public void update(Department obj) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Department findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = connection.prepareStatement("SELECT * FROM department WHERE id = ? ");

            st.setInt(1, id);
           rs = st.executeQuery();

           if(rs.next()){
               Department dep = instanciateDepartment(rs);
               return dep;
           }

           return null;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());

        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public List<Department> findAll() {
        return List.of();
    }

    private Department instanciateDepartment(ResultSet rs) throws SQLException {
        Department department = new Department();
        department.setId(rs.getInt("Id"));
        department.setName(rs.getString("Name"));

        return department;
    }
}
