package fr.dorian.model.types;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.UserType;

import fr.dorian.model.enums.RoleTypeEnum;

public class RoleTypeEnumType implements UserType {

	private static final int[] SQL_TYPES = { Types.VARCHAR };

	public int[] sqlTypes() {
		return SQL_TYPES;
	}

	@SuppressWarnings("rawtypes")
	public Class returnedClass() {
		return RoleTypeEnum.class;
	}

	public boolean equals(Object x, Object y) {
		return x == y;
	}

	public Object deepCopy(Object value) {
		return value;
	}

	public boolean isMutable() {
		return false;
	}

	public Object nullSafeGet(ResultSet resultSet, String[] names, Object owner) throws HibernateException,
			SQLException {
		String name = resultSet.getString(names[0]);
		return resultSet.wasNull() ? null : RoleTypeEnum.valueOf(name);
	}

	public void nullSafeSet(PreparedStatement statement, Object value, int index) throws HibernateException,
			SQLException {

		if (value == null) {
			statement.setNull(index, Types.VARCHAR);
		} else if (value instanceof RoleTypeEnum) {
			RoleTypeEnum e = (RoleTypeEnum) value;
			statement.setString(index, e.toString());
		} else {
			throw new HibernateException("Invalid parameter" + (value.getClass().getName()));
		}
	}

	@Override
	public Object nullSafeGet(ResultSet resultSet, String[] names,
			SessionImplementor arg2, Object owner) throws HibernateException,
			SQLException {
		return this.nullSafeGet(resultSet, names, owner);
	}

	@Override
	public void nullSafeSet(PreparedStatement statement, Object value, int index,
			SessionImplementor arg3) throws HibernateException, SQLException {
		this.nullSafeSet(statement, value, index);
	}
	
	public int hashCode(Object x) throws HibernateException {
		return x.hashCode();
	}

	public Serializable disassemble(Object value) throws HibernateException {
		return (Serializable) value;
	}

	public Object assemble(Serializable cached, Object owner) throws HibernateException {
		return cached;
	}

	public Object replace(Object original, Object target, Object owner) throws HibernateException {
		return original;
	}
}
