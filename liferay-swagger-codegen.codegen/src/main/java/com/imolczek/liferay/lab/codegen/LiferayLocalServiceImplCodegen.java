package com.imolczek.liferay.lab.codegen;

import io.swagger.codegen.CliOption;
import io.swagger.codegen.CodegenConfig;
import io.swagger.codegen.CodegenConstants;
import io.swagger.codegen.CodegenType;
import io.swagger.codegen.languages.AbstractJavaCodegen;

public class LiferayLocalServiceImplCodegen extends AbstractJavaCodegen implements CodegenConfig {

	@Override
	public CodegenType getTag() {
		return CodegenType.CLIENT;
	}

	@Override
	public String getName() {
		return "LiferayLocalServiceImpl";
	}

	@Override
	public String getHelp() {
		return "Liferay Local Service Impl";
	}

    @Override
    public String toApiFilename(String name) {
        return super.toApiFilename(name) + "LocalServiceImpl";
    }
    
    @Override
    public void processOpts() {
    	super.processOpts();
    	String modelPackage = (String) additionalProperties.get(CodegenConstants.MODEL_PACKAGE);
    	int lastDot = modelPackage.lastIndexOf(".");
    	String servicePackage = modelPackage.substring(0, lastDot) + ".service";
    	additionalProperties.put("servicePackage", servicePackage);
    }
    
}
