package com.fr.zut.model.enums.type;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.UserType;

import com.fr.zut.model.enums.RoleTypeEnum;

public class RoleTypeEnumType implements UserType {
	
	//private static final int[] SQL_TYPES = { Types.VARCHAR };
	private static final int[] SQL_TYPES = { Types.INTEGER };

	@Override
	public Object assemble(Serializable cached, Object owner)
			throws HibernateException {
		return cached;
	}

	@Override
	public Object deepCopy(Object arg0) throws HibernateException {
		return arg0;
	}

	@Override
	public Serializable disassemble(Object value) throws HibernateException {
		return (Serializable) value;
	}

	@Override
	public boolean equals(Object arg0, Object arg1) throws HibernateException {
		return arg0 == arg1;
	}

	@Override
	public int hashCode(Object arg0) throws HibernateException {
		return arg0.hashCode();
	}

	@Override
	public boolean isMutable() {
		return false;
	}

	/**
	 * From database
	 */
	@Override
	public Object nullSafeGet(ResultSet resultSet, String[] names,
			SessionImplementor sessionImplementor, Object arg3) throws HibernateException,
			SQLException {
		
//		String name = resultSet.getString(names[0]);
//		return resultSet.wasNull() ? null : RoleTypeEnum.valueOf(name);
		Integer code = resultSet.getInt(names[0]);
		return resultSet.wasNull() ? null : RoleTypeEnum.fromCode(code);
	}

	/**
	 * To database
	 */
	@Override
	public void nullSafeSet(PreparedStatement statement, Object value, int index,
			SessionImplementor sessionImplementor) throws HibernateException, SQLException {
		
//		if (value == null) {
//			statement.setNull(index, Types.VARCHAR);
//		} else if(value instanceof RoleTypeEnum){
//			RoleTypeEnum e = (RoleTypeEnum) value;
//			statement.setString(index, e.name());
//		}  else {
//			throw new HibernateException("Invalid parameter" + (value.getClass().getName()));
//		}
		if (value == null) {
			statement.setNull(index, Types.INTEGER);
		} else if(value instanceof RoleTypeEnum){
			RoleTypeEnum e = (RoleTypeEnum) value;
			statement.setInt(index, e.getCode());
		}  else {
			throw new HibernateException("Invalid parameter" + (value.getClass().getName()));
		}
	}

	@Override
	public Object replace(Object original, Object target, Object owner)
			throws HibernateException {
		return original;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Class returnedClass() {
		return RoleTypeEnum.class;
	}

	@Override
	public int[] sqlTypes() {
		return SQL_TYPES;
	}

}
