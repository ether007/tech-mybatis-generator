package ${package};

<#assign serviceClass = tableClass.shortClassName + serviceSuffix>

<#assign mapperClass = tableClass.shortClassName + mapperSuffix>
<#assign mapperVar = tableClass.variableName + mapperSuffix>

<#assign entityClass = tableClass.shortClassName>
<#assign entityVar = tableClass.variableName>

<#assign ClassName = tableClass.shortClassName + serviceImplSuffix>

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import ${tableClass.fullClassName};
import ${servicePackage}.${serviceClass};
import ${mapperPackage}.${mapperClass};
import java.time.LocalDateTime;
import org.apache.ibatis.session.RowBounds;
import tk.mybatis.mapper.entity.Example;

/**
* 通用 serviceImpl 代码生成器
*
* @author ${author}
*/
@Service
public class ${ClassName} implements ${serviceClass}{

    @Autowired
    private ${mapperClass} ${mapperVar};

    @Override
    public int save(${entityClass} ${entityVar}) {
        return ${mapperVar}.insert(${entityVar});
    }

    @Override
    public int updateById(${entityClass} ${entityVar}) {
        return ${mapperVar}.updateByPrimaryKeySelective(${entityVar});
    }

    @Override
    public ${entityClass} selectById(Long id) {
       return ${mapperVar}.selectByPrimaryKey(id);
    }

    @Override
    public int deleteById(Long id) {
        ${entityClass} ${entityVar} = new ${entityClass}();
        ${entityVar}.setId(id).setIsDeleted((byte) 1).setUpdatedAt(LocalDateTime.now());
        return ${mapperVar}.updateByPrimaryKeySelective(${entityVar});
    }


    @Override
    public int countByExample(Example example) {
        return ${mapperVar}.selectCountByExample(example);
    }

    @Override
    public List<${entityClass}> selectByExample(Example example, RowBounds rowBounds) {
        return ${mapperVar}.selectByExampleAndRowBounds(example,rowBounds);
    }
}




