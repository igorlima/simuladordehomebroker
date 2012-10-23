package com.eatj.s43.igorribeirolima.simuladordehomebroker.util;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Configuracao_de_Consulta {
	private static final String BUNDLE_NAME = "com.eatj.s43.igorribeirolima.simuladordehomebroker.util.configConsulta"; //$NON-NLS-1$

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle
			.getBundle(BUNDLE_NAME);

	private Configuracao_de_Consulta() {
	}

	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
