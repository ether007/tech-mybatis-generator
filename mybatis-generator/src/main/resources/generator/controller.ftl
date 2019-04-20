package ${package};

<#assign serviceClass = tableClass.shortClassName + serviceSuffix>
<#assign serviceVar = tableClass.variableName + serviceSuffix>

<#assign entityClass = tableClass.shortClassName>
<#assign entityVar = tableClass.variableName>
<#assign ClassName = entityClass + controllerSuffix>

import javax.validation.Valid;
import java.util.List;
import com.github.pagehelper.PageRowBounds;
import tk.mybatis.mapper.entity.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import vip.corejava.common.*;

import ${tableClass.fullClassName};
import ${servicerPackage}.${serviceClass};

/**
* 通用 Controller 代码生成器
*
* @author ${author}
*/

@RestController
@RequestMapping("/${entityVar}")
public class ${ClassName}{

  @Autowired
  private ${serviceClass}  ${serviceVar};

  @RequestMapping("/save")
  public Response save(@RequestBody @Valid Request<${entityClass}, ${entityClass}> request) {
      int ret = ${serviceVar}.save(request.getForm());
      if (ret == 1) {
          return list(request);
      }
      return Response.notFound();
  }

  @RequestMapping("/update")
  public Object update(@RequestBody @Valid Request<${entityClass}, ${entityClass}> request) {
      int ret = ${serviceVar}.updateById(request.getForm());
      if (ret == 1) {
          return list(request);
       }
      return Response.notFound();
  }

  @RequestMapping("/delete")
  public Response delete(@RequestBody @Valid Request<${entityClass}, ${entityClass}> request) {
      Long id = request.getForm().getId();
      int ret = ${serviceVar}.deleteById(id);
      if (ret == 1) {
          return list(request);
      }
      return Response.notFound();
  }

  @RequestMapping("/selectById")
  public Response selectById(@RequestParam(name = "id") Long id) {
      User user = userService.selectById(id);
      if (user != null) {
          return Response.ok(user);
      }
      return Response.notFound();
  }

  @RequestMapping("/list")
  public Response list(@RequestBody Request<${entityClass}, ${entityClass}> request) {
      Pagination page = request.getPagination();
      Example example = createExample(request);

      int total = ${serviceVar}.countByExample(example);
      page.setTotal(total);
      int offset = page.offset();
      int pageSize = page.getPageSize();
      PageRowBounds rowBounds = new PageRowBounds(offset, pageSize);

      List<User> list = ${serviceVar}.selectByExample(example, rowBounds);
      PageBody pageBody = new PageBody(list,page);

      return Response.ok(pageBody);
  }

  private Example createExample(Request<${entityClass}, ${entityClass}> request) {
    Example example = new Example(${entityClass}.class);
    Example.Criteria crit = example.createCriteria();
    crit.andEqualTo("isDeleted",0);
    crit.andEqualTo("isHidden",0);
    example.orderBy("id").desc();
    return example;
  }

}




