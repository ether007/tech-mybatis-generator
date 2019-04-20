package ${package};

<#assign entityClass = tableClass.shortClassName>
<#assign entityVar = tableClass.variableName>
<#assign ClassName = tableClass.shortClassName + serviceSuffix>

import java.util.List;
import ${tableClass.fullClassName};
import org.apache.ibatis.session.RowBounds;
import tk.mybatis.mapper.entity.Example;


/**
* 通用 service 代码生成器
*
* @author ${author}
*/
public interface ${ClassName}{

    int save(${entityClass} ${entityVar});

    int updateById(${entityClass} ${entityVar});

    ${entityClass} selectById(Long id);

    int deleteById(Long id);

    int countByExample(Example example);

    List<${entityClass}> selectByExample(Example example, RowBounds rowBounds);
}




