package com.imolczek.liferay.lab.codegen;

import io.swagger.codegen.CodegenConfig;
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
    
}
