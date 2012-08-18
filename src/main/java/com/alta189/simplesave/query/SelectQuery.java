/*
 * This file is part of SimpleSave
 *
 * SimpleSave is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * SimpleSave is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.alta189.simplesave.query;

import com.alta189.simplesave.Database;

public class SelectQuery<T> extends Query<T> {
	private final Database db;
	private final Class<T> tableClass;
	private final WhereQuery<T> where = new WhereQuery<T>(this);
	private final LimitQuery<T> limit = new LimitQuery<T>(this);

	public SelectQuery(Database db, Class<T> tableClass) {
		super(QueryType.SELECT);
		this.db = db;
		this.tableClass = tableClass;
	}

	public WhereQuery<T> where() {
		return where;
	}
	
	public LimitQuery<T> limit() {
		return limit;
	}

	public Class<T> getTableClass() {
		return tableClass;
	}

	@Override
	public QueryResult<T> execute() {
		return db.execute(this);
	}

}
