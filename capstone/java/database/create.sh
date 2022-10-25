#!/bin/bash
export PGPASSWORD='postgres1'
BASEDIR=$(dirname $0)
DATABASE=final_capstone
sql -U postgres -f "$BASEDIR/dropdb.sql" &&
createdb -U postgres $DATABASE &&
sql -U postgres -d $DATABASE -f "$BASEDIR/schema.sql" &&
sql -U postgres -d $DATABASE -f "$BASEDIR/data.sql" &&
sql -U postgres -d $DATABASE -f "$BASEDIR/user.sql"
