package script.db

databaseChangeLog(logicalFilePath: 'script/db/agile_issue_link_type.groovy') {
    changeSet(id: '2018-06-14-agile-issue-link-type', author: 'dinghuang123@gmail.com') {
        createTable(tableName: "agile_issue_link_type", remarks: '敏捷开发Issue链接类型') {
            column(name: 'link_type_id', type: 'BIGINT UNSIGNED', remarks: '主键') {
                constraints(nullable: false)
            }
            column(name: 'link_name', type: 'VARCHAR(255)', remarks: '链接名称') {
                constraints(nullable: false)
            }
            column(name: 'in_ward', type: 'VARCHAR(255)', remarks: '主动选择名称') {
                constraints(nullable: false)
            }
            column(name: 'out_ward', type: 'VARCHAR(255)', remarks: '被动展示名称') {
                constraints(nullable: false)
            }
            column(name: "object_version_number", type: "BIGINT UNSIGNED", defaultValue: "1")
            column(name: "created_by", type: "BIGINT UNSIGNED", defaultValue: "0")
            column(name: "creation_date", type: "DATETIME", defaultValueComputed: "CURRENT_TIMESTAMP")
            column(name: "last_updated_by", type: "BIGINT UNSIGNED", defaultValue: "0")
            column(name: "last_update_date", type: "DATETIME", defaultValueComputed: "CURRENT_TIMESTAMP")
        }
    }

    changeSet(id: '2018-06-15-agile-issue-link-type', author: 'dinghuang123@gmail.com') {
        addPrimaryKey(tableName: 'agile_issue_link_type', columnNames: 'link_type_id', constraintName: '')
        addAutoIncrement(schemaName: '', tableName: 'agile_issue_link_type', columnName: 'link_type_id', columnDataType: 'BIGINT UNSIGNED')
    }

    changeSet(id: '2018-06-25-agile-issue-link-type-add-column', author: 'dinghuang123@gmail.com') {
        addColumn(tableName: 'agile_issue_link_type') {
            column(name: 'project_id', type: 'BIGINT UNSIGNED', remarks: '项目id')
        }
        addNotNullConstraint(tableName: 'agile_issue_link_type', columnName: 'project_id', columnDataType: "BIGINT UNSIGNED")
    }

    changeSet(id: '2018-06-25-agile-issue-link-type-init-data', author: 'dinghuang123@gmail.com') {
        sql(stripComments: true, splitStatements: true, endDelimiter: ';') {
            "INSERT INTO agile_issue_link_type ( link_name, in_ward, out_ward, project_id ) SELECT 'Blocks','is blocked by','blocks',agile_project_info.project_id FROM agile_project_info;\n" +
                    "INSERT INTO agile_issue_link_type ( link_name, in_ward, out_ward, project_id ) SELECT 'Clones','is cloned by','clones',agile_project_info.project_id FROM agile_project_info;\n" +
                    "INSERT INTO agile_issue_link_type ( link_name, in_ward, out_ward, project_id ) SELECT 'Duplicate','is duplicated by','duplicates',agile_project_info.project_id FROM agile_project_info;\n" +
                    "INSERT INTO agile_issue_link_type ( link_name, in_ward, out_ward, project_id ) SELECT 'Relates','relates to','relates to',agile_project_info.project_id FROM agile_project_info;"
        }
    }
}