/**
${pojo.getClassJavaDoc(pojo.getDeclarationName() + " generated by hbm2java", 0)}
*/
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
<#include "Ejb3TypeDeclaration.ftl"/>
${pojo.getClassModifiers()} ${pojo.getDeclarationType()} ${pojo.getDeclarationName()} ${pojo.getExtendsDeclaration()} ${pojo.getImplementsDeclaration()}