# �ͻ���ϵ����ϵͳ
���������
�����
1.��ܵĴ��ʹ��git���а汾���ơ���guns����IDEA��������Ŀ�й���GitHub�ϡ�
��GitHub��ַ��https://github.com/workerbo/GraduationProject ����Readme��ϸ���ܣ���  20:03 2019/2/16��F5��ݼ���
2.ҵ�����̷�����������ݿ��ĵ��ı༭�� 10:31 2019/2/22
3.��Ŀ�������ݿ⣬������ݿ�ű���
4.����Ŀ���г����޸ģ��ɹ����в����޸��ύ��GitHub���½���֧����Demoʵ�顣 17:17 2019/2/23
4.���ҵ��ģ�����ݿ�����ơ��� 15:39 2019/2/24
5.��ɺ�̨�߸�ģ��ҳ�����ɾ�Ĳ�Ĵ��    16:34 2019/3/2

����滮
1.���ɹ��������flowable�����ҵ�����̿��ơ�
2.����Swegger��������ӿ��ĵ���
3.Ȩ�޺����ݷ�Χ�����ã���̨����Աҳ��������
4.���ĳ���
5.��������ɲ����������

## ����ϵͳ����
1.�û����� 2.��ɫ���� 3.���Ź��� 4.�˵����� 5.�ֵ���� 6.ҵ����־ 7.��¼��־ 8.��ع��� 9.֪ͨ���� 10.��������

## ��Ŀ�ص�
1. ����SpringBoot�����˴�����Ŀ���ú�maven������������רע��ҵ�񿪷������صķְ���ʽ�����������ҡ�
2. ���Ƶ���־��¼��ϵ���ɼ�¼��¼��־��ҵ�������־(�ɼ�¼����ǰ�Ͳ����������)���쳣��־�����ݿ⣬ͨ��@BussinessLogע���LogObjectHolder.me().set()������ҵ�������־�ɾ����¼�ĸ��û���ִ������Щҵ���޸�����Щ���ݣ�������־��¼Ϊ�첽ִ�У��������@BussinessLogע���LogObjectHolder��LogManager��LogAop�ࡣ
3. ����beetlģ�������ǰ̨ҳ����з�װ�Ͳ�֣�ʹӷ�׵�html�����ü�࣬������ά����
4. �Գ���js������ж��η�װ��ʹjs�����ü�࣬������ά�����������webapp/static/js/common�ļ�����js���롣
5. ����ehcache��ܶԾ������õĲ�ѯ���л��棬���������ٶȣ��������ConstantFactory����@Cacheable��ǵķ�����
6. controller�����map + warpper��ʽ�ķ��ؽ�������ظ�ǰ�˸�Ϊ�������ݣ�����μ�com.stylefeng.guns.modular.system.warpper���о����ࡣ
7. ��ֹXSS������ͨ��XssFilter������е�����ķǷ��ַ������й����Լ��滻��
8. �򵥿��õĴ���������ϵ��ͨ��SimpleTemplateEngine�����ɴ�����ҳ��ת����ɾ�Ĳ��ͨ�ÿ�������htmlҳ���Լ���ص�js������������Service��Dao��������Щ�����Ϊ��ѡ�ģ�ͨ��ContextConfig�µ�һЩ��xxxSwitch���أ�������������ģ����룬������ʱ�����������ҵ���ϡ�
9. ��������ͳһ���쳣���ػ��ƣ�����@ControllerAdviceͳһ���쳣���أ������com.stylefeng.guns.core.aop.GlobalExceptionHandler�ࡣ
10. ҳ��ͳһ��js key-value����ģʽд����ÿ��ҳ������һ��Ψһ��ȫ�ֱ��������js������Ч�ʣ�������Ч��ֹ�����Ա��������ĺ�����/������ͻ�����ҿ��Ը��õ�ȥά�����롣

## ����javabean��ʽ��spring����
�Լ��Ϊ���ģ������˴�ͳ���״�ӷ��xml���ã�����javabean�ķ�ʽ����spring��������Ŀ�����ã�����ʾ��Ϊ����mybatis-plus������Դ:
```
@Configuration
@MapperScan(basePackages = {"com.stylefeng.guns.modular.*.dao", "com.stylefeng.guns.common.persistence.dao"})
public class MybatisPlusConfig {

    @Autowired
    DruidProperties druidProperties;

    /**
     * mybatis-plus��ҳ���
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        paginationInterceptor.setDialectType(DBType.MYSQL.getDb());
        return paginationInterceptor;
    }
}
```

## ҵ����־��¼
��־��¼����aop(LogAop��)��ʽ�����а���@BussinessLogע��ķ�������aop���룬���¼�µ�ǰ�û�ִ������Щ��������@BussinessLog value���Ե����ݣ�������漰�������޸ģ���ȡ��ǰhttp���������requestParameters��LogObjectHolder���л����Object����������ֶ����Ƚϣ������ڱ༭֮ǰ�Ļ�ȡ����ӿ�����Ҫ���汻�޸Ķ���֮ǰ���ֶ���Ϣ������־���ݻ��첽�������ݿ��У�ͨ��ScheduledThreadPoolExecutor�ࣩ��

## beetl��ǰ̨ҳ��Ĳ�����װ
���磬����ҳ��ֳ������֣�ÿ�����ֵ���һ��ҳ�棬���ӱ���ά��
```
<!--��ർ����ʼ-->
    @include("/common/_tab.html"){}
<!--��ർ������-->

<!--�Ҳಿ�ֿ�ʼ-->
    @include("/common/_right.html"){}
<!--�Ҳಿ�ֽ���-->

<!--�Ҳ������ʼ-->
    @include("/common/_theme.html"){}
<!--�Ҳ��������-->
```
�Լ����ظ���html���а�װ��ʹǰ��ҳ�����רע��ҵ��ʵ�֣����磬������ҳ�����ð�������ȡ
```
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="renderer" content="webkit" /><!-- ��360�����Ĭ��ѡ��webkit�ں� -->

<!-- ȫ��css -->
<link rel="shortcut icon" href="${ctxPath}/static/favicon.ico">
<!-- ȫ��js -->
<script src="${ctxPath}/static/js/jquery.min.js?v=2.1.4"></script>
<body class="gray-bg">
	<div class="wrapper wrapper-content">
		${layoutContent}
	</div>
	<script src="${ctxPath}/static/js/content.js?v=1.0.0"></script>
</body>
</html>
```
����ҳ��ʱ��ֻ���д���´��뼴��
```
@layout("/common/_container.html"){
<div class="row">
    <div class="col-sm-12">
        <div class="ibox float-e-margins">
            <div class="ibox-title">
                <h5>���Ź���</h5>
            </div>
            <div class="ibox-content">
               //�Զ�������
            </div>
        </div>
    </div>
</div>
<script src="${ctxPath}/static/modular/system/dept/dept.js"></script>
@}
```
����beetl���÷���ο�beetl˵���ĵ���

## ��js���ô���ķ�װ
��webapp/static/js/commonĿ¼�У��жԳ���js����ķ�װ������Feng.js������Feng.info()��Feng.success()��Feng.error()�����������ֱ��װ����ͨ��ʾ���ɹ���ʾ��������ʾ�Ĵ��룬����layer��ʾ������ʹ�á�

## �����ͼƬ�ϴ�����
guns��web-upload���ж��η�װ����ͼƬ���ϴ�������ֻ��2�д��뼴��ʵ�֣�����
```
var avatarUp = new $WebUpload("avatar");
avatarUp.init();
```
����ʵ����ο�static/js/common/web-upload-object.js

## ����controller�㣬map+warpper���ط�ʽ
map+warpper��ʽ��Ϊ��controller��ķ��ؽ��ʹ��BeanKit�������ԭ��beanת��ΪMap�ĵ���ʽ(����ԭ��beanֱ����map����ʽ)�����õ���д��һ����װ���ٰ�װһ�����map��ʹ����Ĳ������Ӿ��壬�����к��壬�����һ�����ӣ����磬�ڷ��ظ�ǰ̨һ���Ա�ʱ�����ݿ�����1����2��Ů������ֱ�ӷ��ظ�ǰ̨����ôǰ̨��ʾ��ʱ����Ҫ����һ���жϣ�����ǰ��˷��뿪��ʱ��������һ�ν������ĵ��ĳɱ������ǲ���warpper��װ����ʽ������ֱ�Ӱѷ��ؽ����װһ�£����綯̬����һ���ֶ�sexNameֱ�ӷ��ظ�ǰ̨�Ա���������Ƽ��ɡ�

## ����mybatis���ݷ�Χ��������ʵ�ֶ�����Ȩ�޵Ĺ���
Guns�����ݷ�Χ������ָ����ӵ����ͬ��ɫ���û������ݲ��ŵĲ�ͬ������Ӧ������ɸѡ��������Ų���ͬ����ô�п���չʾ���ľ��������ǲ�һ�µ�.����˵Guns�����ݷ�Χ�������Բ���idΪ��λ����ʶ�ģ�����������ݷ�Χ������?ֻ������ص�mapper�ӿڵĲ���������һ��DataScope���󼴿ɣ�DataScope���������ֶΣ�scopeName������ʶsql����в���id���ֶ����ƣ�����deptiid����id����һ���ֶ�deptIds���Ǿ�����Ҫ���˵Ĳ���id�ļ���.������ԭ������:����mapper�а���DataScope����ķ�������ȡ��ԭʼsql������һ����װ���Ʋ���id��deptIds��Χ�ڵ����ݽ���չʾ.

## swagger api����ʹ��˵��
swagger��������а���@ApiOperationע��Ŀ�����������ͬʱ��������@ApiImplicitParamsע���ǽӿ��еĲ����������÷���ο�CodeController���е��÷���
```
 @ApiOperation("���ɴ���")
 @ApiImplicitParams({
         @ApiImplicitParam(name = "moduleName", value = "ģ������", required = true, dataType = "String"),
         @ApiImplicitParam(name = "bizChName", value = "ҵ������", required = true, dataType = "String"),
         @ApiImplicitParam(name = "bizEnName", value = "ҵ��Ӣ������", required = true, dataType = "String"),
         @ApiImplicitParam(name = "path", value = "��Ŀ������·��", required = true, dataType = "String")
 })
 @RequestMapping(value = "/generate", method = RequestMethod.POST)
```



