// ============================================================================
//
// Copyright (c) 2006-2015, Talend SA
//
// Ce code source a été automatiquement généré par_Talend Open Studio for Data Integration
// / Soumis à la Licence Apache, Version 2.0 (la "Licence") ;
// votre utilisation de ce fichier doit respecter les termes de la Licence.
// Vous pouvez obtenir une copie de la Licence sur
// http://www.apache.org/licenses/LICENSE-2.0
// 
// Sauf lorsqu'explicitement prévu par la loi en vigueur ou accepté par écrit, le logiciel
// distribué sous la Licence est distribué "TEL QUEL",
// SANS GARANTIE OU CONDITION D'AUCUNE SORTE, expresse ou implicite.
// Consultez la Licence pour connaître la terminologie spécifique régissant les autorisations et
// les limites prévues par la Licence.

package gromed.dump_gros_med_brut_0_1;

import routines.Numeric;
import routines.DataOperation;
import routines.TalendDataGenerator;
import routines.TalendStringUtil;
import routines.TalendString;
import routines.StringHandling;
import routines.Relational;
import routines.TalendDate;
import routines.Mathematical;
import routines.system.*;
import routines.system.api.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.Comparator;

@SuppressWarnings("unused")

/**
 * Job: dump_gros_med_brut Purpose: Dump les informations de CIS_XXX.txt dans la
 * base gros_med_brut<br>
 * Description: Load chaque fichier CIS_XXX.txt, dans la table du même nom (full
 * string). <br>
 * 
 * @author user@talend.com
 * @version 8.0.1.20211109_1610
 * @status
 */
public class dump_gros_med_brut implements TalendJob {

	protected static void logIgnoredError(String message, Throwable cause) {
		System.err.println(message);
		if (cause != null) {
			cause.printStackTrace();
		}

	}

	public final Object obj = new Object();

	// for transmiting parameters purpose
	private Object valueObject = null;

	public Object getValueObject() {
		return this.valueObject;
	}

	public void setValueObject(Object valueObject) {
		this.valueObject = valueObject;
	}

	private final static String defaultCharset = java.nio.charset.Charset.defaultCharset().name();

	private final static String utf8Charset = "UTF-8";

	// contains type for every context property
	public class PropertiesWithType extends java.util.Properties {
		private static final long serialVersionUID = 1L;
		private java.util.Map<String, String> propertyTypes = new java.util.HashMap<>();

		public PropertiesWithType(java.util.Properties properties) {
			super(properties);
		}

		public PropertiesWithType() {
			super();
		}

		public void setContextType(String key, String type) {
			propertyTypes.put(key, type);
		}

		public String getContextType(String key) {
			return propertyTypes.get(key);
		}
	}

	// create and load default properties
	private java.util.Properties defaultProps = new java.util.Properties();

	// create application properties with default
	public class ContextProperties extends PropertiesWithType {

		private static final long serialVersionUID = 1L;

		public ContextProperties(java.util.Properties properties) {
			super(properties);
		}

		public ContextProperties() {
			super();
		}

		public void synchronizeContext() {

			if (source != null) {

				this.setProperty("source", source.toString());

			}

			if (GrosMed_Login != null) {

				this.setProperty("GrosMed_Login", GrosMed_Login.toString());

			}

			if (GrosMed_Port != null) {

				this.setProperty("GrosMed_Port", GrosMed_Port.toString());

			}

			if (GrosMed_Server != null) {

				this.setProperty("GrosMed_Server", GrosMed_Server.toString());

			}

			if (GrosMed_Database != null) {

				this.setProperty("GrosMed_Database", GrosMed_Database.toString());

			}

			if (GrosMed_Password != null) {

				this.setProperty("GrosMed_Password", GrosMed_Password.toString());

			}

			if (GrosMed_AdditionalParams != null) {

				this.setProperty("GrosMed_AdditionalParams", GrosMed_AdditionalParams.toString());

			}

			if (gros_med_brut_Port != null) {

				this.setProperty("gros_med_brut_Port", gros_med_brut_Port.toString());

			}

			if (gros_med_brut_AdditionalParams != null) {

				this.setProperty("gros_med_brut_AdditionalParams", gros_med_brut_AdditionalParams.toString());

			}

			if (gros_med_brut_Login != null) {

				this.setProperty("gros_med_brut_Login", gros_med_brut_Login.toString());

			}

			if (gros_med_brut_Database != null) {

				this.setProperty("gros_med_brut_Database", gros_med_brut_Database.toString());

			}

			if (gros_med_brut_Password != null) {

				this.setProperty("gros_med_brut_Password", gros_med_brut_Password.toString());

			}

			if (gros_med_brut_Server != null) {

				this.setProperty("gros_med_brut_Server", gros_med_brut_Server.toString());

			}

			if (gros_med_brut1_Port != null) {

				this.setProperty("gros_med_brut1_Port", gros_med_brut1_Port.toString());

			}

			if (gros_med_brut1_Database != null) {

				this.setProperty("gros_med_brut1_Database", gros_med_brut1_Database.toString());

			}

			if (gros_med_brut1_AdditionalParams != null) {

				this.setProperty("gros_med_brut1_AdditionalParams", gros_med_brut1_AdditionalParams.toString());

			}

			if (gros_med_brut1_Server != null) {

				this.setProperty("gros_med_brut1_Server", gros_med_brut1_Server.toString());

			}

			if (gros_med_brut1_Login != null) {

				this.setProperty("gros_med_brut1_Login", gros_med_brut1_Login.toString());

			}

			if (gros_med_brut1_Password != null) {

				this.setProperty("gros_med_brut1_Password", gros_med_brut1_Password.toString());

			}

		}

		// if the stored or passed value is "<TALEND_NULL>" string, it mean null
		public String getStringValue(String key) {
			String origin_value = this.getProperty(key);
			if (NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY.equals(origin_value)) {
				return null;
			}
			return origin_value;
		}

		public String source;

		public String getSource() {
			return this.source;
		}

		public String GrosMed_Login;

		public String getGrosMed_Login() {
			return this.GrosMed_Login;
		}

		public String GrosMed_Port;

		public String getGrosMed_Port() {
			return this.GrosMed_Port;
		}

		public String GrosMed_Server;

		public String getGrosMed_Server() {
			return this.GrosMed_Server;
		}

		public String GrosMed_Database;

		public String getGrosMed_Database() {
			return this.GrosMed_Database;
		}

		public java.lang.String GrosMed_Password;

		public java.lang.String getGrosMed_Password() {
			return this.GrosMed_Password;
		}

		public String GrosMed_AdditionalParams;

		public String getGrosMed_AdditionalParams() {
			return this.GrosMed_AdditionalParams;
		}

		public String gros_med_brut_Port;

		public String getGros_med_brut_Port() {
			return this.gros_med_brut_Port;
		}

		public String gros_med_brut_AdditionalParams;

		public String getGros_med_brut_AdditionalParams() {
			return this.gros_med_brut_AdditionalParams;
		}

		public String gros_med_brut_Login;

		public String getGros_med_brut_Login() {
			return this.gros_med_brut_Login;
		}

		public String gros_med_brut_Database;

		public String getGros_med_brut_Database() {
			return this.gros_med_brut_Database;
		}

		public java.lang.String gros_med_brut_Password;

		public java.lang.String getGros_med_brut_Password() {
			return this.gros_med_brut_Password;
		}

		public String gros_med_brut_Server;

		public String getGros_med_brut_Server() {
			return this.gros_med_brut_Server;
		}

		public String gros_med_brut1_Port;

		public String getGros_med_brut1_Port() {
			return this.gros_med_brut1_Port;
		}

		public String gros_med_brut1_Database;

		public String getGros_med_brut1_Database() {
			return this.gros_med_brut1_Database;
		}

		public String gros_med_brut1_AdditionalParams;

		public String getGros_med_brut1_AdditionalParams() {
			return this.gros_med_brut1_AdditionalParams;
		}

		public String gros_med_brut1_Server;

		public String getGros_med_brut1_Server() {
			return this.gros_med_brut1_Server;
		}

		public String gros_med_brut1_Login;

		public String getGros_med_brut1_Login() {
			return this.gros_med_brut1_Login;
		}

		public java.lang.String gros_med_brut1_Password;

		public java.lang.String getGros_med_brut1_Password() {
			return this.gros_med_brut1_Password;
		}
	}

	protected ContextProperties context = new ContextProperties(); // will be instanciated by MS.

	public ContextProperties getContext() {
		return this.context;
	}

	private final String jobVersion = "0.1";
	private final String jobName = "dump_gros_med_brut";
	private final String projectName = "GROMED";
	public Integer errorCode = null;
	private String currentComponent = "";

	private final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();
	private final static java.util.Map<String, Object> junitGlobalMap = new java.util.HashMap<String, Object>();

	private final java.util.Map<String, Long> start_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Long> end_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Boolean> ok_Hash = new java.util.HashMap<String, Boolean>();
	public final java.util.List<String[]> globalBuffer = new java.util.ArrayList<String[]>();

	private RunStat runStat = new RunStat();

	// OSGi DataSource
	private final static String KEY_DB_DATASOURCES = "KEY_DB_DATASOURCES";

	private final static String KEY_DB_DATASOURCES_RAW = "KEY_DB_DATASOURCES_RAW";

	public void setDataSources(java.util.Map<String, javax.sql.DataSource> dataSources) {
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		for (java.util.Map.Entry<String, javax.sql.DataSource> dataSourceEntry : dataSources.entrySet()) {
			talendDataSources.put(dataSourceEntry.getKey(),
					new routines.system.TalendDataSource(dataSourceEntry.getValue()));
		}
		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}

	public void setDataSourceReferences(List serviceReferences) throws Exception {

		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		java.util.Map<String, javax.sql.DataSource> dataSources = new java.util.HashMap<String, javax.sql.DataSource>();

		for (java.util.Map.Entry<String, javax.sql.DataSource> entry : BundleUtils
				.getServices(serviceReferences, javax.sql.DataSource.class).entrySet()) {
			dataSources.put(entry.getKey(), entry.getValue());
			talendDataSources.put(entry.getKey(), new routines.system.TalendDataSource(entry.getValue()));
		}

		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}

	private final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
	private final java.io.PrintStream errorMessagePS = new java.io.PrintStream(new java.io.BufferedOutputStream(baos));

	public String getExceptionStackTrace() {
		if ("failure".equals(this.getStatus())) {
			errorMessagePS.flush();
			return baos.toString();
		}
		return null;
	}

	private Exception exception;

	public Exception getException() {
		if ("failure".equals(this.getStatus())) {
			return this.exception;
		}
		return null;
	}

	private class TalendException extends Exception {

		private static final long serialVersionUID = 1L;

		private java.util.Map<String, Object> globalMap = null;
		private Exception e = null;
		private String currentComponent = null;
		private String virtualComponentName = null;

		public void setVirtualComponentName(String virtualComponentName) {
			this.virtualComponentName = virtualComponentName;
		}

		private TalendException(Exception e, String errorComponent, final java.util.Map<String, Object> globalMap) {
			this.currentComponent = errorComponent;
			this.globalMap = globalMap;
			this.e = e;
		}

		public Exception getException() {
			return this.e;
		}

		public String getCurrentComponent() {
			return this.currentComponent;
		}

		public String getExceptionCauseMessage(Exception e) {
			Throwable cause = e;
			String message = null;
			int i = 10;
			while (null != cause && 0 < i--) {
				message = cause.getMessage();
				if (null == message) {
					cause = cause.getCause();
				} else {
					break;
				}
			}
			if (null == message) {
				message = e.getClass().getName();
			}
			return message;
		}

		@Override
		public void printStackTrace() {
			if (!(e instanceof TalendException || e instanceof TDieException)) {
				if (virtualComponentName != null && currentComponent.indexOf(virtualComponentName + "_") == 0) {
					globalMap.put(virtualComponentName + "_ERROR_MESSAGE", getExceptionCauseMessage(e));
				}
				globalMap.put(currentComponent + "_ERROR_MESSAGE", getExceptionCauseMessage(e));
				System.err.println("Exception in component " + currentComponent + " (" + jobName + ")");
			}
			if (!(e instanceof TDieException)) {
				if (e instanceof TalendException) {
					e.printStackTrace();
				} else {
					e.printStackTrace();
					e.printStackTrace(errorMessagePS);
					dump_gros_med_brut.this.exception = e;
				}
			}
			if (!(e instanceof TalendException)) {
				try {
					for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
						if (m.getName().compareTo(currentComponent + "_error") == 0) {
							m.invoke(dump_gros_med_brut.this, new Object[] { e, currentComponent, globalMap });
							break;
						}
					}

					if (!(e instanceof TDieException)) {
					}
				} catch (Exception e) {
					this.e.printStackTrace();
				}
			}
		}
	}

	public void tFileInputDelimited_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tMap_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBOutput_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFileInputDelimited_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tMap_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBOutput_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFileOutputDelimited_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFileInputDelimited_3_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_3_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tMap_3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_3_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBOutput_3_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_3_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFileOutputDelimited_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_3_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFileInputDelimited_4_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_4_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tMap_4_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_4_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBOutput_4_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_4_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFileOutputDelimited_3_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_4_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFileInputDelimited_5_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_5_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tMap_5_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_5_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBOutput_5_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_5_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFileOutputDelimited_4_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_5_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFileInputDelimited_6_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_6_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tMap_6_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_6_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBOutput_6_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_6_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFileOutputDelimited_5_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_6_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_3_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_3_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_4_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_4_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_5_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_5_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_6_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tPostjob_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tPostjob_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tChronometerStop_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tChronometerStop_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tAdvancedHash_row5_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tAdvancedHash_row4_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_3_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tAdvancedHash_row7_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_4_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tAdvancedHash_row9_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_5_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tAdvancedHash_row11_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_6_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFileInputDelimited_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tFileInputDelimited_2_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tFileInputDelimited_3_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tFileInputDelimited_4_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tFileInputDelimited_5_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tFileInputDelimited_6_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tPostjob_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tChronometerStop_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public static class standardStruct implements routines.system.IPersistableRow<standardStruct> {
		final static byte[] commonByteArrayLock_GROMED_dump_gros_med_brut = new byte[0];
		static byte[] commonByteArray_GROMED_dump_gros_med_brut = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public String codeCIS;

		public String getCodeCIS() {
			return this.codeCIS;
		}

		public String denominationMedicament;

		public String getDenominationMedicament() {
			return this.denominationMedicament;
		}

		public String formePharmaceutique;

		public String getFormePharmaceutique() {
			return this.formePharmaceutique;
		}

		public String voiesAdministration;

		public String getVoiesAdministration() {
			return this.voiesAdministration;
		}

		public String statutAdministratifAMM;

		public String getStatutAdministratifAMM() {
			return this.statutAdministratifAMM;
		}

		public String typeProcedureAMM;

		public String getTypeProcedureAMM() {
			return this.typeProcedureAMM;
		}

		public String etatCommercialisation;

		public String getEtatCommercialisation() {
			return this.etatCommercialisation;
		}

		public String dateAMM;

		public String getDateAMM() {
			return this.dateAMM;
		}

		public String estDisponible;

		public String getEstDisponible() {
			return this.estDisponible;
		}

		public String numeroEuropeen;

		public String getNumeroEuropeen() {
			return this.numeroEuropeen;
		}

		public String titulaires;

		public String getTitulaires() {
			return this.titulaires;
		}

		public String estEnSurveillanceRenforcee;

		public String getEstEnSurveillanceRenforcee() {
			return this.estEnSurveillanceRenforcee;
		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + ((this.codeCIS == null) ? 0 : this.codeCIS.hashCode());

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final standardStruct other = (standardStruct) obj;

			if (this.codeCIS == null) {
				if (other.codeCIS != null)
					return false;

			} else if (!this.codeCIS.equals(other.codeCIS))

				return false;

			return true;
		}

		public void copyDataTo(standardStruct other) {

			other.codeCIS = this.codeCIS;
			other.denominationMedicament = this.denominationMedicament;
			other.formePharmaceutique = this.formePharmaceutique;
			other.voiesAdministration = this.voiesAdministration;
			other.statutAdministratifAMM = this.statutAdministratifAMM;
			other.typeProcedureAMM = this.typeProcedureAMM;
			other.etatCommercialisation = this.etatCommercialisation;
			other.dateAMM = this.dateAMM;
			other.estDisponible = this.estDisponible;
			other.numeroEuropeen = this.numeroEuropeen;
			other.titulaires = this.titulaires;
			other.estEnSurveillanceRenforcee = this.estEnSurveillanceRenforcee;

		}

		public void copyKeysDataTo(standardStruct other) {

			other.codeCIS = this.codeCIS;

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_GROMED_dump_gros_med_brut.length) {
					if (length < 1024 && commonByteArray_GROMED_dump_gros_med_brut.length == 0) {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[1024];
					} else {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_GROMED_dump_gros_med_brut, 0, length);
				strReturn = new String(commonByteArray_GROMED_dump_gros_med_brut, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_GROMED_dump_gros_med_brut.length) {
					if (length < 1024 && commonByteArray_GROMED_dump_gros_med_brut.length == 0) {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[1024];
					} else {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_GROMED_dump_gros_med_brut, 0, length);
				strReturn = new String(commonByteArray_GROMED_dump_gros_med_brut, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_GROMED_dump_gros_med_brut) {

				try {

					int length = 0;

					this.codeCIS = readString(dis);

					this.denominationMedicament = readString(dis);

					this.formePharmaceutique = readString(dis);

					this.voiesAdministration = readString(dis);

					this.statutAdministratifAMM = readString(dis);

					this.typeProcedureAMM = readString(dis);

					this.etatCommercialisation = readString(dis);

					this.dateAMM = readString(dis);

					this.estDisponible = readString(dis);

					this.numeroEuropeen = readString(dis);

					this.titulaires = readString(dis);

					this.estEnSurveillanceRenforcee = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_GROMED_dump_gros_med_brut) {

				try {

					int length = 0;

					this.codeCIS = readString(dis);

					this.denominationMedicament = readString(dis);

					this.formePharmaceutique = readString(dis);

					this.voiesAdministration = readString(dis);

					this.statutAdministratifAMM = readString(dis);

					this.typeProcedureAMM = readString(dis);

					this.etatCommercialisation = readString(dis);

					this.dateAMM = readString(dis);

					this.estDisponible = readString(dis);

					this.numeroEuropeen = readString(dis);

					this.titulaires = readString(dis);

					this.estEnSurveillanceRenforcee = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.codeCIS, dos);

				// String

				writeString(this.denominationMedicament, dos);

				// String

				writeString(this.formePharmaceutique, dos);

				// String

				writeString(this.voiesAdministration, dos);

				// String

				writeString(this.statutAdministratifAMM, dos);

				// String

				writeString(this.typeProcedureAMM, dos);

				// String

				writeString(this.etatCommercialisation, dos);

				// String

				writeString(this.dateAMM, dos);

				// String

				writeString(this.estDisponible, dos);

				// String

				writeString(this.numeroEuropeen, dos);

				// String

				writeString(this.titulaires, dos);

				// String

				writeString(this.estEnSurveillanceRenforcee, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.codeCIS, dos);

				// String

				writeString(this.denominationMedicament, dos);

				// String

				writeString(this.formePharmaceutique, dos);

				// String

				writeString(this.voiesAdministration, dos);

				// String

				writeString(this.statutAdministratifAMM, dos);

				// String

				writeString(this.typeProcedureAMM, dos);

				// String

				writeString(this.etatCommercialisation, dos);

				// String

				writeString(this.dateAMM, dos);

				// String

				writeString(this.estDisponible, dos);

				// String

				writeString(this.numeroEuropeen, dos);

				// String

				writeString(this.titulaires, dos);

				// String

				writeString(this.estEnSurveillanceRenforcee, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("codeCIS=" + codeCIS);
			sb.append(",denominationMedicament=" + denominationMedicament);
			sb.append(",formePharmaceutique=" + formePharmaceutique);
			sb.append(",voiesAdministration=" + voiesAdministration);
			sb.append(",statutAdministratifAMM=" + statutAdministratifAMM);
			sb.append(",typeProcedureAMM=" + typeProcedureAMM);
			sb.append(",etatCommercialisation=" + etatCommercialisation);
			sb.append(",dateAMM=" + dateAMM);
			sb.append(",estDisponible=" + estDisponible);
			sb.append(",numeroEuropeen=" + numeroEuropeen);
			sb.append(",titulaires=" + titulaires);
			sb.append(",estEnSurveillanceRenforcee=" + estEnSurveillanceRenforcee);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(standardStruct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.codeCIS, other.codeCIS);
			if (returnValue != 0) {
				return returnValue;
			}

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class row1Struct implements routines.system.IPersistableRow<row1Struct> {
		final static byte[] commonByteArrayLock_GROMED_dump_gros_med_brut = new byte[0];
		static byte[] commonByteArray_GROMED_dump_gros_med_brut = new byte[0];

		public String codeCIS;

		public String getCodeCIS() {
			return this.codeCIS;
		}

		public String denominationMedoc;

		public String getDenominationMedoc() {
			return this.denominationMedoc;
		}

		public String formePharma;

		public String getFormePharma() {
			return this.formePharma;
		}

		public String voiesDAdministration;

		public String getVoiesDAdministration() {
			return this.voiesDAdministration;
		}

		public String statusAd;

		public String getStatusAd() {
			return this.statusAd;
		}

		public String type;

		public String getType() {
			return this.type;
		}

		public String etat;

		public String getEtat() {
			return this.etat;
		}

		public String dateAMM;

		public String getDateAMM() {
			return this.dateAMM;
		}

		public String statutBdm;

		public String getStatutBdm() {
			return this.statutBdm;
		}

		public String numEU;

		public String getNumEU() {
			return this.numEU;
		}

		public String titulaire;

		public String getTitulaire() {
			return this.titulaire;
		}

		public String surveillance;

		public String getSurveillance() {
			return this.surveillance;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_GROMED_dump_gros_med_brut.length) {
					if (length < 1024 && commonByteArray_GROMED_dump_gros_med_brut.length == 0) {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[1024];
					} else {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_GROMED_dump_gros_med_brut, 0, length);
				strReturn = new String(commonByteArray_GROMED_dump_gros_med_brut, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_GROMED_dump_gros_med_brut.length) {
					if (length < 1024 && commonByteArray_GROMED_dump_gros_med_brut.length == 0) {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[1024];
					} else {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_GROMED_dump_gros_med_brut, 0, length);
				strReturn = new String(commonByteArray_GROMED_dump_gros_med_brut, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_GROMED_dump_gros_med_brut) {

				try {

					int length = 0;

					this.codeCIS = readString(dis);

					this.denominationMedoc = readString(dis);

					this.formePharma = readString(dis);

					this.voiesDAdministration = readString(dis);

					this.statusAd = readString(dis);

					this.type = readString(dis);

					this.etat = readString(dis);

					this.dateAMM = readString(dis);

					this.statutBdm = readString(dis);

					this.numEU = readString(dis);

					this.titulaire = readString(dis);

					this.surveillance = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_GROMED_dump_gros_med_brut) {

				try {

					int length = 0;

					this.codeCIS = readString(dis);

					this.denominationMedoc = readString(dis);

					this.formePharma = readString(dis);

					this.voiesDAdministration = readString(dis);

					this.statusAd = readString(dis);

					this.type = readString(dis);

					this.etat = readString(dis);

					this.dateAMM = readString(dis);

					this.statutBdm = readString(dis);

					this.numEU = readString(dis);

					this.titulaire = readString(dis);

					this.surveillance = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.codeCIS, dos);

				// String

				writeString(this.denominationMedoc, dos);

				// String

				writeString(this.formePharma, dos);

				// String

				writeString(this.voiesDAdministration, dos);

				// String

				writeString(this.statusAd, dos);

				// String

				writeString(this.type, dos);

				// String

				writeString(this.etat, dos);

				// String

				writeString(this.dateAMM, dos);

				// String

				writeString(this.statutBdm, dos);

				// String

				writeString(this.numEU, dos);

				// String

				writeString(this.titulaire, dos);

				// String

				writeString(this.surveillance, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.codeCIS, dos);

				// String

				writeString(this.denominationMedoc, dos);

				// String

				writeString(this.formePharma, dos);

				// String

				writeString(this.voiesDAdministration, dos);

				// String

				writeString(this.statusAd, dos);

				// String

				writeString(this.type, dos);

				// String

				writeString(this.etat, dos);

				// String

				writeString(this.dateAMM, dos);

				// String

				writeString(this.statutBdm, dos);

				// String

				writeString(this.numEU, dos);

				// String

				writeString(this.titulaire, dos);

				// String

				writeString(this.surveillance, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("codeCIS=" + codeCIS);
			sb.append(",denominationMedoc=" + denominationMedoc);
			sb.append(",formePharma=" + formePharma);
			sb.append(",voiesDAdministration=" + voiesDAdministration);
			sb.append(",statusAd=" + statusAd);
			sb.append(",type=" + type);
			sb.append(",etat=" + etat);
			sb.append(",dateAMM=" + dateAMM);
			sb.append(",statutBdm=" + statutBdm);
			sb.append(",numEU=" + numEU);
			sb.append(",titulaire=" + titulaire);
			sb.append(",surveillance=" + surveillance);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row1Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public void tFileInputDelimited_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tFileInputDelimited_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				row1Struct row1 = new row1Struct();
				standardStruct standard = new standardStruct();

				/**
				 * [tDBOutput_1 begin ] start
				 */

				ok_Hash.put("tDBOutput_1", false);
				start_Hash.put("tDBOutput_1", System.currentTimeMillis());

				currentComponent = "tDBOutput_1";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "standard");
				}

				int tos_count_tDBOutput_1 = 0;

				int updateKeyCount_tDBOutput_1 = 1;
				if (updateKeyCount_tDBOutput_1 < 1) {
					throw new RuntimeException("For update, Schema must have a key");
				} else if (updateKeyCount_tDBOutput_1 == 12 && true) {
					System.err.println("For update, every Schema column can not be a key");
				}

				int nb_line_tDBOutput_1 = 0;
				int nb_line_update_tDBOutput_1 = 0;
				int nb_line_inserted_tDBOutput_1 = 0;
				int nb_line_deleted_tDBOutput_1 = 0;
				int nb_line_rejected_tDBOutput_1 = 0;

				int deletedCount_tDBOutput_1 = 0;
				int updatedCount_tDBOutput_1 = 0;
				int insertedCount_tDBOutput_1 = 0;
				int rowsToCommitCount_tDBOutput_1 = 0;
				int rejectedCount_tDBOutput_1 = 0;

				String tableName_tDBOutput_1 = "cis_bdpm";
				boolean whetherReject_tDBOutput_1 = false;

				java.util.Calendar calendar_tDBOutput_1 = java.util.Calendar.getInstance();
				calendar_tDBOutput_1.set(1, 0, 1, 0, 0, 0);
				long year1_tDBOutput_1 = calendar_tDBOutput_1.getTime().getTime();
				calendar_tDBOutput_1.set(10000, 0, 1, 0, 0, 0);
				long year10000_tDBOutput_1 = calendar_tDBOutput_1.getTime().getTime();
				long date_tDBOutput_1;

				java.sql.Connection conn_tDBOutput_1 = null;

				String properties_tDBOutput_1 = context.gros_med_brut1_AdditionalParams;
				if (properties_tDBOutput_1 == null || properties_tDBOutput_1.trim().length() == 0) {
					properties_tDBOutput_1 = "rewriteBatchedStatements=true&allowLoadLocalInfile=true";
				} else {
					if (!properties_tDBOutput_1.contains("rewriteBatchedStatements=")) {
						properties_tDBOutput_1 += "&rewriteBatchedStatements=true";
					}

					if (!properties_tDBOutput_1.contains("allowLoadLocalInfile=")) {
						properties_tDBOutput_1 += "&allowLoadLocalInfile=true";
					}
				}

				String url_tDBOutput_1 = "jdbc:mariadb://" + context.gros_med_brut1_Server + ":"
						+ context.gros_med_brut1_Port + "/" + context.gros_med_brut1_Database + "?"
						+ properties_tDBOutput_1;

				String driverClass_tDBOutput_1 = "org.mariadb.jdbc.Driver";

				String dbUser_tDBOutput_1 = context.gros_med_brut1_Login;

				final String decryptedPassword_tDBOutput_1 = context.gros_med_brut1_Password;

				String dbPwd_tDBOutput_1 = decryptedPassword_tDBOutput_1;
				java.lang.Class.forName(driverClass_tDBOutput_1);

				conn_tDBOutput_1 = java.sql.DriverManager.getConnection(url_tDBOutput_1, dbUser_tDBOutput_1,
						dbPwd_tDBOutput_1);

				resourceMap.put("conn_tDBOutput_1", conn_tDBOutput_1);
				conn_tDBOutput_1.setAutoCommit(false);
				int commitEvery_tDBOutput_1 = 10000;
				int commitCounter_tDBOutput_1 = 0;

				int count_tDBOutput_1 = 0;

				java.sql.PreparedStatement pstmt_tDBOutput_1 = conn_tDBOutput_1
						.prepareStatement("SELECT COUNT(1) FROM `" + "cis_bdpm" + "` WHERE `codeCIS` = ?");
				resourceMap.put("pstmt_tDBOutput_1", pstmt_tDBOutput_1);
				String insert_tDBOutput_1 = "INSERT INTO `" + "cis_bdpm"
						+ "` (`codeCIS`,`denominationMedicament`,`formePharmaceutique`,`voiesAdministration`,`statutAdministratifAMM`,`typeProcedureAMM`,`etatCommercialisation`,`dateAMM`,`estDisponible`,`numeroEuropeen`,`titulaires`,`estEnSurveillanceRenforcee`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

				java.sql.PreparedStatement pstmtInsert_tDBOutput_1 = conn_tDBOutput_1
						.prepareStatement(insert_tDBOutput_1);
				resourceMap.put("pstmtInsert_tDBOutput_1", pstmtInsert_tDBOutput_1);
				String update_tDBOutput_1 = "UPDATE `" + "cis_bdpm"
						+ "` SET `denominationMedicament` = ?,`formePharmaceutique` = ?,`voiesAdministration` = ?,`statutAdministratifAMM` = ?,`typeProcedureAMM` = ?,`etatCommercialisation` = ?,`dateAMM` = ?,`estDisponible` = ?,`numeroEuropeen` = ?,`titulaires` = ?,`estEnSurveillanceRenforcee` = ? WHERE `codeCIS` = ?";

				java.sql.PreparedStatement pstmtUpdate_tDBOutput_1 = conn_tDBOutput_1
						.prepareStatement(update_tDBOutput_1);
				resourceMap.put("pstmtUpdate_tDBOutput_1", pstmtUpdate_tDBOutput_1);

				/**
				 * [tDBOutput_1 begin ] stop
				 */

				/**
				 * [tMap_1 begin ] start
				 */

				ok_Hash.put("tMap_1", false);
				start_Hash.put("tMap_1", System.currentTimeMillis());

				currentComponent = "tMap_1";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row1");
				}

				int tos_count_tMap_1 = 0;

// ###############################
// # Lookup's keys initialization
// ###############################        

// ###############################
// # Vars initialization
				class Var__tMap_1__Struct {
					boolean estDispo;
					boolean estSurRenf;
				}
				Var__tMap_1__Struct Var__tMap_1 = new Var__tMap_1__Struct();
// ###############################

// ###############################
// # Outputs initialization
				standardStruct standard_tmp = new standardStruct();
// ###############################

				/**
				 * [tMap_1 begin ] stop
				 */

				/**
				 * [tFileInputDelimited_1 begin ] start
				 */

				ok_Hash.put("tFileInputDelimited_1", false);
				start_Hash.put("tFileInputDelimited_1", System.currentTimeMillis());

				currentComponent = "tFileInputDelimited_1";

				int tos_count_tFileInputDelimited_1 = 0;

				final routines.system.RowState rowstate_tFileInputDelimited_1 = new routines.system.RowState();

				int nb_line_tFileInputDelimited_1 = 0;
				org.talend.fileprocess.FileInputDelimited fid_tFileInputDelimited_1 = null;
				int limit_tFileInputDelimited_1 = -1;
				try {

					Object filename_tFileInputDelimited_1 = "C:/Users/Ethan/Documents/workspace/GROMED/data/fichiers/CIS_bdpm.txt";
					if (filename_tFileInputDelimited_1 instanceof java.io.InputStream) {

						int footer_value_tFileInputDelimited_1 = 0, random_value_tFileInputDelimited_1 = -1;
						if (footer_value_tFileInputDelimited_1 > 0 || random_value_tFileInputDelimited_1 > 0) {
							throw new java.lang.Exception(
									"When the input source is a stream,footer and random shouldn't be bigger than 0.");
						}

					}
					try {
						fid_tFileInputDelimited_1 = new org.talend.fileprocess.FileInputDelimited(
								"C:/Users/Ethan/Documents/workspace/GROMED/data/fichiers/CIS_bdpm.txt", "ISO-8859-15",
								"\t", "\n", false, 0, 0, limit_tFileInputDelimited_1, -1, false);
					} catch (java.lang.Exception e) {
						globalMap.put("tFileInputDelimited_1_ERROR_MESSAGE", e.getMessage());

						System.err.println(e.getMessage());

					}

					while (fid_tFileInputDelimited_1 != null && fid_tFileInputDelimited_1.nextRecord()) {
						rowstate_tFileInputDelimited_1.reset();

						row1 = null;

						boolean whetherReject_tFileInputDelimited_1 = false;
						row1 = new row1Struct();
						try {

							int columnIndexWithD_tFileInputDelimited_1 = 0;

							columnIndexWithD_tFileInputDelimited_1 = 0;

							row1.codeCIS = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);

							columnIndexWithD_tFileInputDelimited_1 = 1;

							row1.denominationMedoc = fid_tFileInputDelimited_1
									.get(columnIndexWithD_tFileInputDelimited_1);

							columnIndexWithD_tFileInputDelimited_1 = 2;

							row1.formePharma = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);

							columnIndexWithD_tFileInputDelimited_1 = 3;

							row1.voiesDAdministration = fid_tFileInputDelimited_1
									.get(columnIndexWithD_tFileInputDelimited_1);

							columnIndexWithD_tFileInputDelimited_1 = 4;

							row1.statusAd = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);

							columnIndexWithD_tFileInputDelimited_1 = 5;

							row1.type = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);

							columnIndexWithD_tFileInputDelimited_1 = 6;

							row1.etat = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);

							columnIndexWithD_tFileInputDelimited_1 = 7;

							row1.dateAMM = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);

							columnIndexWithD_tFileInputDelimited_1 = 8;

							row1.statutBdm = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);

							columnIndexWithD_tFileInputDelimited_1 = 9;

							row1.numEU = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);

							columnIndexWithD_tFileInputDelimited_1 = 10;

							row1.titulaire = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);

							columnIndexWithD_tFileInputDelimited_1 = 11;

							row1.surveillance = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);

							if (rowstate_tFileInputDelimited_1.getException() != null) {
								throw rowstate_tFileInputDelimited_1.getException();
							}

						} catch (java.lang.Exception e) {
							globalMap.put("tFileInputDelimited_1_ERROR_MESSAGE", e.getMessage());
							whetherReject_tFileInputDelimited_1 = true;

							System.err.println(e.getMessage());
							row1 = null;

						}

						/**
						 * [tFileInputDelimited_1 begin ] stop
						 */

						/**
						 * [tFileInputDelimited_1 main ] start
						 */

						currentComponent = "tFileInputDelimited_1";

						tos_count_tFileInputDelimited_1++;

						/**
						 * [tFileInputDelimited_1 main ] stop
						 */

						/**
						 * [tFileInputDelimited_1 process_data_begin ] start
						 */

						currentComponent = "tFileInputDelimited_1";

						/**
						 * [tFileInputDelimited_1 process_data_begin ] stop
						 */
// Start of branch "row1"
						if (row1 != null) {

							/**
							 * [tMap_1 main ] start
							 */

							currentComponent = "tMap_1";

							if (execStat) {
								runStat.updateStatOnConnection(iterateId, 1, 1

										, "row1"

								);
							}

							boolean hasCasePrimitiveKeyWithNull_tMap_1 = false;

							// ###############################
							// # Input tables (lookups)
							boolean rejectedInnerJoin_tMap_1 = false;
							boolean mainRowRejected_tMap_1 = false;

							// ###############################
							{ // start of Var scope

								// ###############################
								// # Vars tables

								Var__tMap_1__Struct Var = Var__tMap_1;
								Var.estDispo = row1.statutBdm.equals("Alerte");
								Var.estSurRenf = row1.surveillance.equals("Oui");// ###############################
								// ###############################
								// # Output tables

								standard = null;

// # Output table : 'standard'
								standard_tmp.codeCIS = row1.codeCIS;
								standard_tmp.denominationMedicament = row1.denominationMedoc;
								standard_tmp.formePharmaceutique = row1.formePharma;
								standard_tmp.voiesAdministration = row1.voiesDAdministration;
								standard_tmp.statutAdministratifAMM = row1.statusAd;
								standard_tmp.typeProcedureAMM = row1.type;
								standard_tmp.etatCommercialisation = row1.etat;
								standard_tmp.dateAMM = row1.dateAMM;
								standard_tmp.estDisponible = row1.statutBdm;
								standard_tmp.numeroEuropeen = row1.numEU;
								standard_tmp.titulaires = row1.titulaire;
								standard_tmp.estEnSurveillanceRenforcee = row1.surveillance;
								standard = standard_tmp;
// ###############################

							} // end of Var scope

							rejectedInnerJoin_tMap_1 = false;

							tos_count_tMap_1++;

							/**
							 * [tMap_1 main ] stop
							 */

							/**
							 * [tMap_1 process_data_begin ] start
							 */

							currentComponent = "tMap_1";

							/**
							 * [tMap_1 process_data_begin ] stop
							 */
// Start of branch "standard"
							if (standard != null) {

								/**
								 * [tDBOutput_1 main ] start
								 */

								currentComponent = "tDBOutput_1";

								if (execStat) {
									runStat.updateStatOnConnection(iterateId, 1, 1

											, "standard"

									);
								}

								whetherReject_tDBOutput_1 = false;
								if (standard.codeCIS == null) {
									pstmt_tDBOutput_1.setNull(1, java.sql.Types.VARCHAR);
								} else {
									pstmt_tDBOutput_1.setString(1, standard.codeCIS);
								}

								int checkCount_tDBOutput_1 = -1;
								try (java.sql.ResultSet rs_tDBOutput_1 = pstmt_tDBOutput_1.executeQuery()) {
									while (rs_tDBOutput_1.next()) {
										checkCount_tDBOutput_1 = rs_tDBOutput_1.getInt(1);
									}
								}
								if (checkCount_tDBOutput_1 > 0) {
									if (standard.denominationMedicament == null) {
										pstmtUpdate_tDBOutput_1.setNull(1, java.sql.Types.VARCHAR);
									} else {
										pstmtUpdate_tDBOutput_1.setString(1, standard.denominationMedicament);
									}

									if (standard.formePharmaceutique == null) {
										pstmtUpdate_tDBOutput_1.setNull(2, java.sql.Types.VARCHAR);
									} else {
										pstmtUpdate_tDBOutput_1.setString(2, standard.formePharmaceutique);
									}

									if (standard.voiesAdministration == null) {
										pstmtUpdate_tDBOutput_1.setNull(3, java.sql.Types.VARCHAR);
									} else {
										pstmtUpdate_tDBOutput_1.setString(3, standard.voiesAdministration);
									}

									if (standard.statutAdministratifAMM == null) {
										pstmtUpdate_tDBOutput_1.setNull(4, java.sql.Types.VARCHAR);
									} else {
										pstmtUpdate_tDBOutput_1.setString(4, standard.statutAdministratifAMM);
									}

									if (standard.typeProcedureAMM == null) {
										pstmtUpdate_tDBOutput_1.setNull(5, java.sql.Types.VARCHAR);
									} else {
										pstmtUpdate_tDBOutput_1.setString(5, standard.typeProcedureAMM);
									}

									if (standard.etatCommercialisation == null) {
										pstmtUpdate_tDBOutput_1.setNull(6, java.sql.Types.VARCHAR);
									} else {
										pstmtUpdate_tDBOutput_1.setString(6, standard.etatCommercialisation);
									}

									if (standard.dateAMM == null) {
										pstmtUpdate_tDBOutput_1.setNull(7, java.sql.Types.VARCHAR);
									} else {
										pstmtUpdate_tDBOutput_1.setString(7, standard.dateAMM);
									}

									if (standard.estDisponible == null) {
										pstmtUpdate_tDBOutput_1.setNull(8, java.sql.Types.VARCHAR);
									} else {
										pstmtUpdate_tDBOutput_1.setString(8, standard.estDisponible);
									}

									if (standard.numeroEuropeen == null) {
										pstmtUpdate_tDBOutput_1.setNull(9, java.sql.Types.VARCHAR);
									} else {
										pstmtUpdate_tDBOutput_1.setString(9, standard.numeroEuropeen);
									}

									if (standard.titulaires == null) {
										pstmtUpdate_tDBOutput_1.setNull(10, java.sql.Types.VARCHAR);
									} else {
										pstmtUpdate_tDBOutput_1.setString(10, standard.titulaires);
									}

									if (standard.estEnSurveillanceRenforcee == null) {
										pstmtUpdate_tDBOutput_1.setNull(11, java.sql.Types.VARCHAR);
									} else {
										pstmtUpdate_tDBOutput_1.setString(11, standard.estEnSurveillanceRenforcee);
									}

									if (standard.codeCIS == null) {
										pstmtUpdate_tDBOutput_1.setNull(12 + count_tDBOutput_1, java.sql.Types.VARCHAR);
									} else {
										pstmtUpdate_tDBOutput_1.setString(12 + count_tDBOutput_1, standard.codeCIS);
									}

									try {
										int processedCount_tDBOutput_1 = pstmtUpdate_tDBOutput_1.executeUpdate();
										updatedCount_tDBOutput_1 += processedCount_tDBOutput_1;
										rowsToCommitCount_tDBOutput_1 += processedCount_tDBOutput_1;
										nb_line_tDBOutput_1++;
									} catch (java.lang.Exception e) {
										globalMap.put("tDBOutput_1_ERROR_MESSAGE", e.getMessage());
										whetherReject_tDBOutput_1 = true;
										nb_line_tDBOutput_1++;
										System.err.print(e.getMessage());
									}
								} else {
									if (standard.codeCIS == null) {
										pstmtInsert_tDBOutput_1.setNull(1, java.sql.Types.VARCHAR);
									} else {
										pstmtInsert_tDBOutput_1.setString(1, standard.codeCIS);
									}

									if (standard.denominationMedicament == null) {
										pstmtInsert_tDBOutput_1.setNull(2, java.sql.Types.VARCHAR);
									} else {
										pstmtInsert_tDBOutput_1.setString(2, standard.denominationMedicament);
									}

									if (standard.formePharmaceutique == null) {
										pstmtInsert_tDBOutput_1.setNull(3, java.sql.Types.VARCHAR);
									} else {
										pstmtInsert_tDBOutput_1.setString(3, standard.formePharmaceutique);
									}

									if (standard.voiesAdministration == null) {
										pstmtInsert_tDBOutput_1.setNull(4, java.sql.Types.VARCHAR);
									} else {
										pstmtInsert_tDBOutput_1.setString(4, standard.voiesAdministration);
									}

									if (standard.statutAdministratifAMM == null) {
										pstmtInsert_tDBOutput_1.setNull(5, java.sql.Types.VARCHAR);
									} else {
										pstmtInsert_tDBOutput_1.setString(5, standard.statutAdministratifAMM);
									}

									if (standard.typeProcedureAMM == null) {
										pstmtInsert_tDBOutput_1.setNull(6, java.sql.Types.VARCHAR);
									} else {
										pstmtInsert_tDBOutput_1.setString(6, standard.typeProcedureAMM);
									}

									if (standard.etatCommercialisation == null) {
										pstmtInsert_tDBOutput_1.setNull(7, java.sql.Types.VARCHAR);
									} else {
										pstmtInsert_tDBOutput_1.setString(7, standard.etatCommercialisation);
									}

									if (standard.dateAMM == null) {
										pstmtInsert_tDBOutput_1.setNull(8, java.sql.Types.VARCHAR);
									} else {
										pstmtInsert_tDBOutput_1.setString(8, standard.dateAMM);
									}

									if (standard.estDisponible == null) {
										pstmtInsert_tDBOutput_1.setNull(9, java.sql.Types.VARCHAR);
									} else {
										pstmtInsert_tDBOutput_1.setString(9, standard.estDisponible);
									}

									if (standard.numeroEuropeen == null) {
										pstmtInsert_tDBOutput_1.setNull(10, java.sql.Types.VARCHAR);
									} else {
										pstmtInsert_tDBOutput_1.setString(10, standard.numeroEuropeen);
									}

									if (standard.titulaires == null) {
										pstmtInsert_tDBOutput_1.setNull(11, java.sql.Types.VARCHAR);
									} else {
										pstmtInsert_tDBOutput_1.setString(11, standard.titulaires);
									}

									if (standard.estEnSurveillanceRenforcee == null) {
										pstmtInsert_tDBOutput_1.setNull(12, java.sql.Types.VARCHAR);
									} else {
										pstmtInsert_tDBOutput_1.setString(12, standard.estEnSurveillanceRenforcee);
									}

									try {
										int processedCount_tDBOutput_1 = pstmtInsert_tDBOutput_1.executeUpdate();
										insertedCount_tDBOutput_1 += processedCount_tDBOutput_1;
										rowsToCommitCount_tDBOutput_1 += processedCount_tDBOutput_1;
										nb_line_tDBOutput_1++;
									} catch (java.lang.Exception e) {
										globalMap.put("tDBOutput_1_ERROR_MESSAGE", e.getMessage());
										whetherReject_tDBOutput_1 = true;
										nb_line_tDBOutput_1++;
										System.err.print(e.getMessage());
									}
								}
								commitCounter_tDBOutput_1++;

								if (commitEvery_tDBOutput_1 <= commitCounter_tDBOutput_1) {

									if (rowsToCommitCount_tDBOutput_1 != 0) {
									}
									conn_tDBOutput_1.commit();
									if (rowsToCommitCount_tDBOutput_1 != 0) {
										rowsToCommitCount_tDBOutput_1 = 0;
									}
									commitCounter_tDBOutput_1 = 0;

								}

								tos_count_tDBOutput_1++;

								/**
								 * [tDBOutput_1 main ] stop
								 */

								/**
								 * [tDBOutput_1 process_data_begin ] start
								 */

								currentComponent = "tDBOutput_1";

								/**
								 * [tDBOutput_1 process_data_begin ] stop
								 */

								/**
								 * [tDBOutput_1 process_data_end ] start
								 */

								currentComponent = "tDBOutput_1";

								/**
								 * [tDBOutput_1 process_data_end ] stop
								 */

							} // End of branch "standard"

							/**
							 * [tMap_1 process_data_end ] start
							 */

							currentComponent = "tMap_1";

							/**
							 * [tMap_1 process_data_end ] stop
							 */

						} // End of branch "row1"

						/**
						 * [tFileInputDelimited_1 process_data_end ] start
						 */

						currentComponent = "tFileInputDelimited_1";

						/**
						 * [tFileInputDelimited_1 process_data_end ] stop
						 */

						/**
						 * [tFileInputDelimited_1 end ] start
						 */

						currentComponent = "tFileInputDelimited_1";

					}
				} finally {
					if (!((Object) ("C:/Users/Ethan/Documents/workspace/GROMED/data/fichiers/CIS_bdpm.txt") instanceof java.io.InputStream)) {
						if (fid_tFileInputDelimited_1 != null) {
							fid_tFileInputDelimited_1.close();
						}
					}
					if (fid_tFileInputDelimited_1 != null) {
						globalMap.put("tFileInputDelimited_1_NB_LINE", fid_tFileInputDelimited_1.getRowNumber());

					}
				}

				ok_Hash.put("tFileInputDelimited_1", true);
				end_Hash.put("tFileInputDelimited_1", System.currentTimeMillis());

				/**
				 * [tFileInputDelimited_1 end ] stop
				 */

				/**
				 * [tMap_1 end ] start
				 */

				currentComponent = "tMap_1";

// ###############################
// # Lookup hashes releasing
// ###############################      

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row1");
				}

				ok_Hash.put("tMap_1", true);
				end_Hash.put("tMap_1", System.currentTimeMillis());

				/**
				 * [tMap_1 end ] stop
				 */

				/**
				 * [tDBOutput_1 end ] start
				 */

				currentComponent = "tDBOutput_1";

				if (pstmtUpdate_tDBOutput_1 != null) {
					pstmtUpdate_tDBOutput_1.close();
					resourceMap.remove("pstmtUpdate_tDBOutput_1");
				}
				if (pstmtInsert_tDBOutput_1 != null) {
					pstmtInsert_tDBOutput_1.close();
					resourceMap.remove("pstmtInsert_tDBOutput_1");
				}
				if (pstmt_tDBOutput_1 != null) {
					pstmt_tDBOutput_1.close();
					resourceMap.remove("pstmt_tDBOutput_1");
				}
				resourceMap.put("statementClosed_tDBOutput_1", true);
				if (commitCounter_tDBOutput_1 > 0 && rowsToCommitCount_tDBOutput_1 != 0) {

				}
				conn_tDBOutput_1.commit();
				if (commitCounter_tDBOutput_1 > 0 && rowsToCommitCount_tDBOutput_1 != 0) {

					rowsToCommitCount_tDBOutput_1 = 0;
				}
				commitCounter_tDBOutput_1 = 0;

				conn_tDBOutput_1.close();

				resourceMap.put("finish_tDBOutput_1", true);

				nb_line_deleted_tDBOutput_1 = nb_line_deleted_tDBOutput_1 + deletedCount_tDBOutput_1;
				nb_line_update_tDBOutput_1 = nb_line_update_tDBOutput_1 + updatedCount_tDBOutput_1;
				nb_line_inserted_tDBOutput_1 = nb_line_inserted_tDBOutput_1 + insertedCount_tDBOutput_1;
				nb_line_rejected_tDBOutput_1 = nb_line_rejected_tDBOutput_1 + rejectedCount_tDBOutput_1;

				globalMap.put("tDBOutput_1_NB_LINE", nb_line_tDBOutput_1);
				globalMap.put("tDBOutput_1_NB_LINE_UPDATED", nb_line_update_tDBOutput_1);
				globalMap.put("tDBOutput_1_NB_LINE_INSERTED", nb_line_inserted_tDBOutput_1);
				globalMap.put("tDBOutput_1_NB_LINE_DELETED", nb_line_deleted_tDBOutput_1);
				globalMap.put("tDBOutput_1_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_1);

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "standard");
				}

				ok_Hash.put("tDBOutput_1", true);
				end_Hash.put("tDBOutput_1", System.currentTimeMillis());

				/**
				 * [tDBOutput_1 end ] stop
				 */

			} // end the resume

			if (resumeEntryMethodName == null || globalResumeTicket) {
				resumeUtil.addLog("CHECKPOINT", "CONNECTION:SUBJOB_OK:tFileInputDelimited_1:OnSubjobOk", "",
						Thread.currentThread().getId() + "", "", "", "", "", "");
			}

			if (execStat) {
				runStat.updateStatOnConnection("OnSubjobOk1", 0, "ok");
			}

			tFileInputDelimited_2Process(globalMap);

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tFileInputDelimited_1 finally ] start
				 */

				currentComponent = "tFileInputDelimited_1";

				/**
				 * [tFileInputDelimited_1 finally ] stop
				 */

				/**
				 * [tMap_1 finally ] start
				 */

				currentComponent = "tMap_1";

				/**
				 * [tMap_1 finally ] stop
				 */

				/**
				 * [tDBOutput_1 finally ] start
				 */

				currentComponent = "tDBOutput_1";

				try {
					if (resourceMap.get("statementClosed_tDBOutput_1") == null) {
						java.sql.PreparedStatement pstmtUpdateToClose_tDBOutput_1 = null;
						if ((pstmtUpdateToClose_tDBOutput_1 = (java.sql.PreparedStatement) resourceMap
								.remove("pstmtUpdate_tDBOutput_1")) != null) {
							pstmtUpdateToClose_tDBOutput_1.close();
						}
						java.sql.PreparedStatement pstmtInsertToClose_tDBOutput_1 = null;
						if ((pstmtInsertToClose_tDBOutput_1 = (java.sql.PreparedStatement) resourceMap
								.remove("pstmtInsert_tDBOutput_1")) != null) {
							pstmtInsertToClose_tDBOutput_1.close();
						}
						java.sql.PreparedStatement pstmtToClose_tDBOutput_1 = null;
						if ((pstmtToClose_tDBOutput_1 = (java.sql.PreparedStatement) resourceMap
								.remove("pstmt_tDBOutput_1")) != null) {
							pstmtToClose_tDBOutput_1.close();
						}
					}
				} finally {
					if (resourceMap.get("finish_tDBOutput_1") == null) {
						java.sql.Connection ctn_tDBOutput_1 = null;
						if ((ctn_tDBOutput_1 = (java.sql.Connection) resourceMap.get("conn_tDBOutput_1")) != null) {
							try {
								ctn_tDBOutput_1.close();
							} catch (java.sql.SQLException sqlEx_tDBOutput_1) {
								String errorMessage_tDBOutput_1 = "failed to close the connection in tDBOutput_1 :"
										+ sqlEx_tDBOutput_1.getMessage();
								System.err.println(errorMessage_tDBOutput_1);
							}
						}
					}
				}

				/**
				 * [tDBOutput_1 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tFileInputDelimited_1_SUBPROCESS_STATE", 1);
	}

	public static class duplicatedStruct implements routines.system.IPersistableRow<duplicatedStruct> {
		final static byte[] commonByteArrayLock_GROMED_dump_gros_med_brut = new byte[0];
		static byte[] commonByteArray_GROMED_dump_gros_med_brut = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public int id;

		public int getId() {
			return this.id;
		}

		public String codeCIS;

		public String getCodeCIS() {
			return this.codeCIS;
		}

		public String conditionPrescription;

		public String getConditionPrescription() {
			return this.conditionPrescription;
		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + (int) this.id;

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final duplicatedStruct other = (duplicatedStruct) obj;

			if (this.id != other.id)
				return false;

			return true;
		}

		public void copyDataTo(duplicatedStruct other) {

			other.id = this.id;
			other.codeCIS = this.codeCIS;
			other.conditionPrescription = this.conditionPrescription;

		}

		public void copyKeysDataTo(duplicatedStruct other) {

			other.id = this.id;

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_GROMED_dump_gros_med_brut.length) {
					if (length < 1024 && commonByteArray_GROMED_dump_gros_med_brut.length == 0) {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[1024];
					} else {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_GROMED_dump_gros_med_brut, 0, length);
				strReturn = new String(commonByteArray_GROMED_dump_gros_med_brut, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_GROMED_dump_gros_med_brut.length) {
					if (length < 1024 && commonByteArray_GROMED_dump_gros_med_brut.length == 0) {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[1024];
					} else {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_GROMED_dump_gros_med_brut, 0, length);
				strReturn = new String(commonByteArray_GROMED_dump_gros_med_brut, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_GROMED_dump_gros_med_brut) {

				try {

					int length = 0;

					this.id = dis.readInt();

					this.codeCIS = readString(dis);

					this.conditionPrescription = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_GROMED_dump_gros_med_brut) {

				try {

					int length = 0;

					this.id = dis.readInt();

					this.codeCIS = readString(dis);

					this.conditionPrescription = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// int

				dos.writeInt(this.id);

				// String

				writeString(this.codeCIS, dos);

				// String

				writeString(this.conditionPrescription, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// int

				dos.writeInt(this.id);

				// String

				writeString(this.codeCIS, dos);

				// String

				writeString(this.conditionPrescription, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("id=" + String.valueOf(id));
			sb.append(",codeCIS=" + codeCIS);
			sb.append(",conditionPrescription=" + conditionPrescription);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(duplicatedStruct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.id, other.id);
			if (returnValue != 0) {
				return returnValue;
			}

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class outputStruct implements routines.system.IPersistableRow<outputStruct> {
		final static byte[] commonByteArrayLock_GROMED_dump_gros_med_brut = new byte[0];
		static byte[] commonByteArray_GROMED_dump_gros_med_brut = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public String codeCIS;

		public String getCodeCIS() {
			return this.codeCIS;
		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + ((this.codeCIS == null) ? 0 : this.codeCIS.hashCode());

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final outputStruct other = (outputStruct) obj;

			if (this.codeCIS == null) {
				if (other.codeCIS != null)
					return false;

			} else if (!this.codeCIS.equals(other.codeCIS))

				return false;

			return true;
		}

		public void copyDataTo(outputStruct other) {

			other.codeCIS = this.codeCIS;

		}

		public void copyKeysDataTo(outputStruct other) {

			other.codeCIS = this.codeCIS;

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_GROMED_dump_gros_med_brut.length) {
					if (length < 1024 && commonByteArray_GROMED_dump_gros_med_brut.length == 0) {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[1024];
					} else {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_GROMED_dump_gros_med_brut, 0, length);
				strReturn = new String(commonByteArray_GROMED_dump_gros_med_brut, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_GROMED_dump_gros_med_brut.length) {
					if (length < 1024 && commonByteArray_GROMED_dump_gros_med_brut.length == 0) {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[1024];
					} else {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_GROMED_dump_gros_med_brut, 0, length);
				strReturn = new String(commonByteArray_GROMED_dump_gros_med_brut, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_GROMED_dump_gros_med_brut) {

				try {

					int length = 0;

					this.codeCIS = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_GROMED_dump_gros_med_brut) {

				try {

					int length = 0;

					this.codeCIS = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.codeCIS, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.codeCIS, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("codeCIS=" + codeCIS);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(outputStruct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.codeCIS, other.codeCIS);
			if (returnValue != 0) {
				return returnValue;
			}

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class row3Struct implements routines.system.IPersistableRow<row3Struct> {
		final static byte[] commonByteArrayLock_GROMED_dump_gros_med_brut = new byte[0];
		static byte[] commonByteArray_GROMED_dump_gros_med_brut = new byte[0];

		public String codeCIS;

		public String getCodeCIS() {
			return this.codeCIS;
		}

		public String conditionPres;

		public String getConditionPres() {
			return this.conditionPres;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_GROMED_dump_gros_med_brut.length) {
					if (length < 1024 && commonByteArray_GROMED_dump_gros_med_brut.length == 0) {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[1024];
					} else {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_GROMED_dump_gros_med_brut, 0, length);
				strReturn = new String(commonByteArray_GROMED_dump_gros_med_brut, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_GROMED_dump_gros_med_brut.length) {
					if (length < 1024 && commonByteArray_GROMED_dump_gros_med_brut.length == 0) {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[1024];
					} else {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_GROMED_dump_gros_med_brut, 0, length);
				strReturn = new String(commonByteArray_GROMED_dump_gros_med_brut, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_GROMED_dump_gros_med_brut) {

				try {

					int length = 0;

					this.codeCIS = readString(dis);

					this.conditionPres = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_GROMED_dump_gros_med_brut) {

				try {

					int length = 0;

					this.codeCIS = readString(dis);

					this.conditionPres = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.codeCIS, dos);

				// String

				writeString(this.conditionPres, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.codeCIS, dos);

				// String

				writeString(this.conditionPres, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("codeCIS=" + codeCIS);
			sb.append(",conditionPres=" + conditionPres);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row3Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class after_tFileInputDelimited_2Struct
			implements routines.system.IPersistableRow<after_tFileInputDelimited_2Struct> {
		final static byte[] commonByteArrayLock_GROMED_dump_gros_med_brut = new byte[0];
		static byte[] commonByteArray_GROMED_dump_gros_med_brut = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public String codeCIS;

		public String getCodeCIS() {
			return this.codeCIS;
		}

		public String conditionPres;

		public String getConditionPres() {
			return this.conditionPres;
		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + ((this.codeCIS == null) ? 0 : this.codeCIS.hashCode());

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final after_tFileInputDelimited_2Struct other = (after_tFileInputDelimited_2Struct) obj;

			if (this.codeCIS == null) {
				if (other.codeCIS != null)
					return false;

			} else if (!this.codeCIS.equals(other.codeCIS))

				return false;

			return true;
		}

		public void copyDataTo(after_tFileInputDelimited_2Struct other) {

			other.codeCIS = this.codeCIS;
			other.conditionPres = this.conditionPres;

		}

		public void copyKeysDataTo(after_tFileInputDelimited_2Struct other) {

			other.codeCIS = this.codeCIS;

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_GROMED_dump_gros_med_brut.length) {
					if (length < 1024 && commonByteArray_GROMED_dump_gros_med_brut.length == 0) {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[1024];
					} else {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_GROMED_dump_gros_med_brut, 0, length);
				strReturn = new String(commonByteArray_GROMED_dump_gros_med_brut, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_GROMED_dump_gros_med_brut.length) {
					if (length < 1024 && commonByteArray_GROMED_dump_gros_med_brut.length == 0) {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[1024];
					} else {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_GROMED_dump_gros_med_brut, 0, length);
				strReturn = new String(commonByteArray_GROMED_dump_gros_med_brut, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_GROMED_dump_gros_med_brut) {

				try {

					int length = 0;

					this.codeCIS = readString(dis);

					this.conditionPres = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_GROMED_dump_gros_med_brut) {

				try {

					int length = 0;

					this.codeCIS = readString(dis);

					this.conditionPres = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.codeCIS, dos);

				// String

				writeString(this.conditionPres, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.codeCIS, dos);

				// String

				writeString(this.conditionPres, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("codeCIS=" + codeCIS);
			sb.append(",conditionPres=" + conditionPres);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(after_tFileInputDelimited_2Struct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.codeCIS, other.codeCIS);
			if (returnValue != 0) {
				return returnValue;
			}

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public void tFileInputDelimited_2Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tFileInputDelimited_2_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				tDBInput_1Process(globalMap);

				row3Struct row3 = new row3Struct();
				duplicatedStruct duplicated = new duplicatedStruct();
				outputStruct output = new outputStruct();

				/**
				 * [tDBOutput_2 begin ] start
				 */

				ok_Hash.put("tDBOutput_2", false);
				start_Hash.put("tDBOutput_2", System.currentTimeMillis());

				currentComponent = "tDBOutput_2";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "duplicated");
				}

				int tos_count_tDBOutput_2 = 0;

				int nb_line_tDBOutput_2 = 0;
				int nb_line_update_tDBOutput_2 = 0;
				int nb_line_inserted_tDBOutput_2 = 0;
				int nb_line_deleted_tDBOutput_2 = 0;
				int nb_line_rejected_tDBOutput_2 = 0;

				int deletedCount_tDBOutput_2 = 0;
				int updatedCount_tDBOutput_2 = 0;
				int insertedCount_tDBOutput_2 = 0;
				int rowsToCommitCount_tDBOutput_2 = 0;
				int rejectedCount_tDBOutput_2 = 0;

				String tableName_tDBOutput_2 = "cis_cpd_bdpm";
				boolean whetherReject_tDBOutput_2 = false;

				java.util.Calendar calendar_tDBOutput_2 = java.util.Calendar.getInstance();
				calendar_tDBOutput_2.set(1, 0, 1, 0, 0, 0);
				long year1_tDBOutput_2 = calendar_tDBOutput_2.getTime().getTime();
				calendar_tDBOutput_2.set(10000, 0, 1, 0, 0, 0);
				long year10000_tDBOutput_2 = calendar_tDBOutput_2.getTime().getTime();
				long date_tDBOutput_2;

				java.sql.Connection conn_tDBOutput_2 = null;

				String properties_tDBOutput_2 = context.gros_med_brut1_AdditionalParams;
				if (properties_tDBOutput_2 == null || properties_tDBOutput_2.trim().length() == 0) {
					properties_tDBOutput_2 = "rewriteBatchedStatements=true&allowLoadLocalInfile=true";
				} else {
					if (!properties_tDBOutput_2.contains("rewriteBatchedStatements=")) {
						properties_tDBOutput_2 += "&rewriteBatchedStatements=true";
					}

					if (!properties_tDBOutput_2.contains("allowLoadLocalInfile=")) {
						properties_tDBOutput_2 += "&allowLoadLocalInfile=true";
					}
				}

				String url_tDBOutput_2 = "jdbc:mariadb://" + context.gros_med_brut1_Server + ":"
						+ context.gros_med_brut1_Port + "/" + context.gros_med_brut1_Database + "?"
						+ properties_tDBOutput_2;

				String driverClass_tDBOutput_2 = "org.mariadb.jdbc.Driver";

				String dbUser_tDBOutput_2 = context.gros_med_brut1_Login;

				final String decryptedPassword_tDBOutput_2 = context.gros_med_brut1_Password;

				String dbPwd_tDBOutput_2 = decryptedPassword_tDBOutput_2;
				java.lang.Class.forName(driverClass_tDBOutput_2);

				conn_tDBOutput_2 = java.sql.DriverManager.getConnection(url_tDBOutput_2, dbUser_tDBOutput_2,
						dbPwd_tDBOutput_2);

				resourceMap.put("conn_tDBOutput_2", conn_tDBOutput_2);
				conn_tDBOutput_2.setAutoCommit(false);
				int commitEvery_tDBOutput_2 = 10000;
				int commitCounter_tDBOutput_2 = 0;

				int count_tDBOutput_2 = 0;

				try (java.sql.Statement stmtClear_tDBOutput_2 = conn_tDBOutput_2.createStatement()) {
					stmtClear_tDBOutput_2.executeUpdate("DELETE FROM `" + tableName_tDBOutput_2 + "`");
				}

				String insert_tDBOutput_2 = "INSERT INTO `" + "cis_cpd_bdpm"
						+ "` (`id`,`codeCIS`,`conditionPrescription`) VALUES (?,?,?)";
				int batchSize_tDBOutput_2 = 100;
				int batchSizeCounter_tDBOutput_2 = 0;

				java.sql.PreparedStatement pstmt_tDBOutput_2 = conn_tDBOutput_2.prepareStatement(insert_tDBOutput_2);
				resourceMap.put("pstmt_tDBOutput_2", pstmt_tDBOutput_2);

				/**
				 * [tDBOutput_2 begin ] stop
				 */

				/**
				 * [tFileOutputDelimited_1 begin ] start
				 */

				ok_Hash.put("tFileOutputDelimited_1", false);
				start_Hash.put("tFileOutputDelimited_1", System.currentTimeMillis());

				currentComponent = "tFileOutputDelimited_1";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "output");
				}

				int tos_count_tFileOutputDelimited_1 = 0;

				String fileName_tFileOutputDelimited_1 = "";
				fileName_tFileOutputDelimited_1 = (new java.io.File(
						context.source + "log/cis_cpd_bdpm_Unknow_Primarykey.log")).getAbsolutePath().replace("\\",
								"/");
				String fullName_tFileOutputDelimited_1 = null;
				String extension_tFileOutputDelimited_1 = null;
				String directory_tFileOutputDelimited_1 = null;
				if ((fileName_tFileOutputDelimited_1.indexOf("/") != -1)) {
					if (fileName_tFileOutputDelimited_1.lastIndexOf(".") < fileName_tFileOutputDelimited_1
							.lastIndexOf("/")) {
						fullName_tFileOutputDelimited_1 = fileName_tFileOutputDelimited_1;
						extension_tFileOutputDelimited_1 = "";
					} else {
						fullName_tFileOutputDelimited_1 = fileName_tFileOutputDelimited_1.substring(0,
								fileName_tFileOutputDelimited_1.lastIndexOf("."));
						extension_tFileOutputDelimited_1 = fileName_tFileOutputDelimited_1
								.substring(fileName_tFileOutputDelimited_1.lastIndexOf("."));
					}
					directory_tFileOutputDelimited_1 = fileName_tFileOutputDelimited_1.substring(0,
							fileName_tFileOutputDelimited_1.lastIndexOf("/"));
				} else {
					if (fileName_tFileOutputDelimited_1.lastIndexOf(".") != -1) {
						fullName_tFileOutputDelimited_1 = fileName_tFileOutputDelimited_1.substring(0,
								fileName_tFileOutputDelimited_1.lastIndexOf("."));
						extension_tFileOutputDelimited_1 = fileName_tFileOutputDelimited_1
								.substring(fileName_tFileOutputDelimited_1.lastIndexOf("."));
					} else {
						fullName_tFileOutputDelimited_1 = fileName_tFileOutputDelimited_1;
						extension_tFileOutputDelimited_1 = "";
					}
					directory_tFileOutputDelimited_1 = "";
				}
				boolean isFileGenerated_tFileOutputDelimited_1 = true;
				java.io.File filetFileOutputDelimited_1 = new java.io.File(fileName_tFileOutputDelimited_1);
				globalMap.put("tFileOutputDelimited_1_FILE_NAME", fileName_tFileOutputDelimited_1);
				int nb_line_tFileOutputDelimited_1 = 0;
				int splitedFileNo_tFileOutputDelimited_1 = 0;
				int currentRow_tFileOutputDelimited_1 = 0;

				final String OUT_DELIM_tFileOutputDelimited_1 = /** Start field tFileOutputDelimited_1:FIELDSEPARATOR */
						";"/** End field tFileOutputDelimited_1:FIELDSEPARATOR */
				;

				final String OUT_DELIM_ROWSEP_tFileOutputDelimited_1 = /**
																		 * Start field
																		 * tFileOutputDelimited_1:ROWSEPARATOR
																		 */
						"\n"/** End field tFileOutputDelimited_1:ROWSEPARATOR */
				;

				// create directory only if not exists
				if (directory_tFileOutputDelimited_1 != null && directory_tFileOutputDelimited_1.trim().length() != 0) {
					java.io.File dir_tFileOutputDelimited_1 = new java.io.File(directory_tFileOutputDelimited_1);
					if (!dir_tFileOutputDelimited_1.exists()) {
						dir_tFileOutputDelimited_1.mkdirs();
					}
				}

				// routines.system.Row
				java.io.Writer outtFileOutputDelimited_1 = null;

				java.io.File fileToDelete_tFileOutputDelimited_1 = new java.io.File(fileName_tFileOutputDelimited_1);
				if (fileToDelete_tFileOutputDelimited_1.exists()) {
					fileToDelete_tFileOutputDelimited_1.delete();
				}
				outtFileOutputDelimited_1 = new java.io.BufferedWriter(new java.io.OutputStreamWriter(
						new java.io.FileOutputStream(fileName_tFileOutputDelimited_1, false), "ISO-8859-15"));

				resourceMap.put("out_tFileOutputDelimited_1", outtFileOutputDelimited_1);
				resourceMap.put("nb_line_tFileOutputDelimited_1", nb_line_tFileOutputDelimited_1);

				/**
				 * [tFileOutputDelimited_1 begin ] stop
				 */

				/**
				 * [tMap_2 begin ] start
				 */

				ok_Hash.put("tMap_2", false);
				start_Hash.put("tMap_2", System.currentTimeMillis());

				currentComponent = "tMap_2";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row3");
				}

				int tos_count_tMap_2 = 0;

// ###############################
// # Lookup's keys initialization

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row5Struct> tHash_Lookup_row5 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row5Struct>) ((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row5Struct>) globalMap
						.get("tHash_Lookup_row5"));

				row5Struct row5HashKey = new row5Struct();
				row5Struct row5Default = new row5Struct();
// ###############################        

// ###############################
// # Vars initialization
				class Var__tMap_2__Struct {
				}
				Var__tMap_2__Struct Var__tMap_2 = new Var__tMap_2__Struct();
// ###############################

// ###############################
// # Outputs initialization
				duplicatedStruct duplicated_tmp = new duplicatedStruct();
				outputStruct output_tmp = new outputStruct();
// ###############################

				/**
				 * [tMap_2 begin ] stop
				 */

				/**
				 * [tFileInputDelimited_2 begin ] start
				 */

				ok_Hash.put("tFileInputDelimited_2", false);
				start_Hash.put("tFileInputDelimited_2", System.currentTimeMillis());

				currentComponent = "tFileInputDelimited_2";

				int tos_count_tFileInputDelimited_2 = 0;

				final routines.system.RowState rowstate_tFileInputDelimited_2 = new routines.system.RowState();

				int nb_line_tFileInputDelimited_2 = 0;
				org.talend.fileprocess.FileInputDelimited fid_tFileInputDelimited_2 = null;
				int limit_tFileInputDelimited_2 = -1;
				try {

					Object filename_tFileInputDelimited_2 = "C:/Users/Ethan/Documents/workspace/GROMED/data/fichiers/CIS_CPD_bdpm.txt";
					if (filename_tFileInputDelimited_2 instanceof java.io.InputStream) {

						int footer_value_tFileInputDelimited_2 = 0, random_value_tFileInputDelimited_2 = -1;
						if (footer_value_tFileInputDelimited_2 > 0 || random_value_tFileInputDelimited_2 > 0) {
							throw new java.lang.Exception(
									"When the input source is a stream,footer and random shouldn't be bigger than 0.");
						}

					}
					try {
						fid_tFileInputDelimited_2 = new org.talend.fileprocess.FileInputDelimited(
								"C:/Users/Ethan/Documents/workspace/GROMED/data/fichiers/CIS_CPD_bdpm.txt",
								"ISO-8859-15", "\t", "\n", false, 0, 0, limit_tFileInputDelimited_2, -1, false);
					} catch (java.lang.Exception e) {
						globalMap.put("tFileInputDelimited_2_ERROR_MESSAGE", e.getMessage());

						System.err.println(e.getMessage());

					}

					while (fid_tFileInputDelimited_2 != null && fid_tFileInputDelimited_2.nextRecord()) {
						rowstate_tFileInputDelimited_2.reset();

						row3 = null;

						boolean whetherReject_tFileInputDelimited_2 = false;
						row3 = new row3Struct();
						try {

							int columnIndexWithD_tFileInputDelimited_2 = 0;

							columnIndexWithD_tFileInputDelimited_2 = 0;

							row3.codeCIS = fid_tFileInputDelimited_2.get(columnIndexWithD_tFileInputDelimited_2);

							columnIndexWithD_tFileInputDelimited_2 = 1;

							row3.conditionPres = fid_tFileInputDelimited_2.get(columnIndexWithD_tFileInputDelimited_2);

							if (rowstate_tFileInputDelimited_2.getException() != null) {
								throw rowstate_tFileInputDelimited_2.getException();
							}

						} catch (java.lang.Exception e) {
							globalMap.put("tFileInputDelimited_2_ERROR_MESSAGE", e.getMessage());
							whetherReject_tFileInputDelimited_2 = true;

							System.err.println(e.getMessage());
							row3 = null;

						}

						/**
						 * [tFileInputDelimited_2 begin ] stop
						 */

						/**
						 * [tFileInputDelimited_2 main ] start
						 */

						currentComponent = "tFileInputDelimited_2";

						tos_count_tFileInputDelimited_2++;

						/**
						 * [tFileInputDelimited_2 main ] stop
						 */

						/**
						 * [tFileInputDelimited_2 process_data_begin ] start
						 */

						currentComponent = "tFileInputDelimited_2";

						/**
						 * [tFileInputDelimited_2 process_data_begin ] stop
						 */
// Start of branch "row3"
						if (row3 != null) {

							/**
							 * [tMap_2 main ] start
							 */

							currentComponent = "tMap_2";

							if (execStat) {
								runStat.updateStatOnConnection(iterateId, 1, 1

										, "row3"

								);
							}

							boolean hasCasePrimitiveKeyWithNull_tMap_2 = false;

							// ###############################
							// # Input tables (lookups)
							boolean rejectedInnerJoin_tMap_2 = false;
							boolean mainRowRejected_tMap_2 = false;

							///////////////////////////////////////////////
							// Starting Lookup Table "row5"
							///////////////////////////////////////////////

							boolean forceLooprow5 = false;

							row5Struct row5ObjectFromLookup = null;

							if (!rejectedInnerJoin_tMap_2) { // G_TM_M_020

								hasCasePrimitiveKeyWithNull_tMap_2 = false;

								row5HashKey.codeCIS = row3.codeCIS;

								row5HashKey.hashCodeDirty = true;

								tHash_Lookup_row5.lookup(row5HashKey);

								if (!tHash_Lookup_row5.hasNext()) { // G_TM_M_090

									rejectedInnerJoin_tMap_2 = true;

								} // G_TM_M_090

							} // G_TM_M_020

							if (tHash_Lookup_row5 != null && tHash_Lookup_row5.getCount(row5HashKey) > 1) { // G 071

								// System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row5'
								// and it contains more one result from keys : row5.codeCIS = '" +
								// row5HashKey.codeCIS + "'");
							} // G 071

							row5Struct row5 = null;

							row5Struct fromLookup_row5 = null;
							row5 = row5Default;

							if (tHash_Lookup_row5 != null && tHash_Lookup_row5.hasNext()) { // G 099

								fromLookup_row5 = tHash_Lookup_row5.next();

							} // G 099

							if (fromLookup_row5 != null) {
								row5 = fromLookup_row5;
							}

							// ###############################
							{ // start of Var scope

								// ###############################
								// # Vars tables

								Var__tMap_2__Struct Var = Var__tMap_2;// ###############################
								// ###############################
								// # Output tables

								duplicated = null;
								output = null;

								if (!rejectedInnerJoin_tMap_2) {

// # Output table : 'duplicated'
									duplicated_tmp.id = 0;
									duplicated_tmp.codeCIS = row3.codeCIS;
									duplicated_tmp.conditionPrescription = row3.conditionPres;
									duplicated = duplicated_tmp;
								} // closing inner join bracket (1)
// ###### START REJECTS ##### 

// # Output reject table : 'output'
// # Filter conditions 
								if (rejectedInnerJoin_tMap_2) {
									output_tmp.codeCIS = row3.codeCIS;
									output = output_tmp;
								} // closing filter/reject
// ###############################

							} // end of Var scope

							rejectedInnerJoin_tMap_2 = false;

							tos_count_tMap_2++;

							/**
							 * [tMap_2 main ] stop
							 */

							/**
							 * [tMap_2 process_data_begin ] start
							 */

							currentComponent = "tMap_2";

							/**
							 * [tMap_2 process_data_begin ] stop
							 */
// Start of branch "duplicated"
							if (duplicated != null) {

								/**
								 * [tDBOutput_2 main ] start
								 */

								currentComponent = "tDBOutput_2";

								if (execStat) {
									runStat.updateStatOnConnection(iterateId, 1, 1

											, "duplicated"

									);
								}

								whetherReject_tDBOutput_2 = false;
								pstmt_tDBOutput_2.setInt(1, duplicated.id);

								if (duplicated.codeCIS == null) {
									pstmt_tDBOutput_2.setNull(2, java.sql.Types.VARCHAR);
								} else {
									pstmt_tDBOutput_2.setString(2, duplicated.codeCIS);
								}

								if (duplicated.conditionPrescription == null) {
									pstmt_tDBOutput_2.setNull(3, java.sql.Types.VARCHAR);
								} else {
									pstmt_tDBOutput_2.setString(3, duplicated.conditionPrescription);
								}

								pstmt_tDBOutput_2.addBatch();
								nb_line_tDBOutput_2++;

								batchSizeCounter_tDBOutput_2++;
								if (batchSize_tDBOutput_2 <= batchSizeCounter_tDBOutput_2) {
									try {
										int countSum_tDBOutput_2 = 0;
										for (int countEach_tDBOutput_2 : pstmt_tDBOutput_2.executeBatch()) {
											countSum_tDBOutput_2 += (countEach_tDBOutput_2 == java.sql.Statement.EXECUTE_FAILED
													? 0
													: 1);
										}
										rowsToCommitCount_tDBOutput_2 += countSum_tDBOutput_2;
										insertedCount_tDBOutput_2 += countSum_tDBOutput_2;
									} catch (java.sql.BatchUpdateException e) {
										globalMap.put("tDBOutput_2_ERROR_MESSAGE", e.getMessage());
										int countSum_tDBOutput_2 = 0;
										for (int countEach_tDBOutput_2 : e.getUpdateCounts()) {
											countSum_tDBOutput_2 += (countEach_tDBOutput_2 < 0 ? 0
													: countEach_tDBOutput_2);
										}
										rowsToCommitCount_tDBOutput_2 += countSum_tDBOutput_2;
										insertedCount_tDBOutput_2 += countSum_tDBOutput_2;
										System.err.println(e.getMessage());
									}

									batchSizeCounter_tDBOutput_2 = 0;
								}
								commitCounter_tDBOutput_2++;

								if (commitEvery_tDBOutput_2 <= commitCounter_tDBOutput_2) {

									try {
										int countSum_tDBOutput_2 = 0;
										for (int countEach_tDBOutput_2 : pstmt_tDBOutput_2.executeBatch()) {
											countSum_tDBOutput_2 += (countEach_tDBOutput_2 < 0 ? 0 : 1);
										}
										rowsToCommitCount_tDBOutput_2 += countSum_tDBOutput_2;
										insertedCount_tDBOutput_2 += countSum_tDBOutput_2;
									} catch (java.sql.BatchUpdateException e) {
										globalMap.put("tDBOutput_2_ERROR_MESSAGE", e.getMessage());
										int countSum_tDBOutput_2 = 0;
										for (int countEach_tDBOutput_2 : e.getUpdateCounts()) {
											countSum_tDBOutput_2 += (countEach_tDBOutput_2 < 0 ? 0
													: countEach_tDBOutput_2);
										}
										rowsToCommitCount_tDBOutput_2 += countSum_tDBOutput_2;
										insertedCount_tDBOutput_2 += countSum_tDBOutput_2;
										System.err.println(e.getMessage());

									}
									if (rowsToCommitCount_tDBOutput_2 != 0) {
									}
									conn_tDBOutput_2.commit();
									if (rowsToCommitCount_tDBOutput_2 != 0) {
										rowsToCommitCount_tDBOutput_2 = 0;
									}
									commitCounter_tDBOutput_2 = 0;

								}

								tos_count_tDBOutput_2++;

								/**
								 * [tDBOutput_2 main ] stop
								 */

								/**
								 * [tDBOutput_2 process_data_begin ] start
								 */

								currentComponent = "tDBOutput_2";

								/**
								 * [tDBOutput_2 process_data_begin ] stop
								 */

								/**
								 * [tDBOutput_2 process_data_end ] start
								 */

								currentComponent = "tDBOutput_2";

								/**
								 * [tDBOutput_2 process_data_end ] stop
								 */

							} // End of branch "duplicated"

// Start of branch "output"
							if (output != null) {

								/**
								 * [tFileOutputDelimited_1 main ] start
								 */

								currentComponent = "tFileOutputDelimited_1";

								if (execStat) {
									runStat.updateStatOnConnection(iterateId, 1, 1

											, "output"

									);
								}

								StringBuilder sb_tFileOutputDelimited_1 = new StringBuilder();
								if (output.codeCIS != null) {
									sb_tFileOutputDelimited_1.append(output.codeCIS);
								}
								sb_tFileOutputDelimited_1.append(OUT_DELIM_ROWSEP_tFileOutputDelimited_1);

								nb_line_tFileOutputDelimited_1++;
								resourceMap.put("nb_line_tFileOutputDelimited_1", nb_line_tFileOutputDelimited_1);

								outtFileOutputDelimited_1.write(sb_tFileOutputDelimited_1.toString());

								tos_count_tFileOutputDelimited_1++;

								/**
								 * [tFileOutputDelimited_1 main ] stop
								 */

								/**
								 * [tFileOutputDelimited_1 process_data_begin ] start
								 */

								currentComponent = "tFileOutputDelimited_1";

								/**
								 * [tFileOutputDelimited_1 process_data_begin ] stop
								 */

								/**
								 * [tFileOutputDelimited_1 process_data_end ] start
								 */

								currentComponent = "tFileOutputDelimited_1";

								/**
								 * [tFileOutputDelimited_1 process_data_end ] stop
								 */

							} // End of branch "output"

							/**
							 * [tMap_2 process_data_end ] start
							 */

							currentComponent = "tMap_2";

							/**
							 * [tMap_2 process_data_end ] stop
							 */

						} // End of branch "row3"

						/**
						 * [tFileInputDelimited_2 process_data_end ] start
						 */

						currentComponent = "tFileInputDelimited_2";

						/**
						 * [tFileInputDelimited_2 process_data_end ] stop
						 */

						/**
						 * [tFileInputDelimited_2 end ] start
						 */

						currentComponent = "tFileInputDelimited_2";

					}
				} finally {
					if (!((Object) ("C:/Users/Ethan/Documents/workspace/GROMED/data/fichiers/CIS_CPD_bdpm.txt") instanceof java.io.InputStream)) {
						if (fid_tFileInputDelimited_2 != null) {
							fid_tFileInputDelimited_2.close();
						}
					}
					if (fid_tFileInputDelimited_2 != null) {
						globalMap.put("tFileInputDelimited_2_NB_LINE", fid_tFileInputDelimited_2.getRowNumber());

					}
				}

				ok_Hash.put("tFileInputDelimited_2", true);
				end_Hash.put("tFileInputDelimited_2", System.currentTimeMillis());

				/**
				 * [tFileInputDelimited_2 end ] stop
				 */

				/**
				 * [tMap_2 end ] start
				 */

				currentComponent = "tMap_2";

// ###############################
// # Lookup hashes releasing
				if (tHash_Lookup_row5 != null) {
					tHash_Lookup_row5.endGet();
				}
				globalMap.remove("tHash_Lookup_row5");

// ###############################      

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row3");
				}

				ok_Hash.put("tMap_2", true);
				end_Hash.put("tMap_2", System.currentTimeMillis());

				/**
				 * [tMap_2 end ] stop
				 */

				/**
				 * [tDBOutput_2 end ] start
				 */

				currentComponent = "tDBOutput_2";

				try {
					if (batchSizeCounter_tDBOutput_2 != 0) {
						int countSum_tDBOutput_2 = 0;

						for (int countEach_tDBOutput_2 : pstmt_tDBOutput_2.executeBatch()) {
							countSum_tDBOutput_2 += (countEach_tDBOutput_2 == java.sql.Statement.EXECUTE_FAILED ? 0
									: 1);
						}
						rowsToCommitCount_tDBOutput_2 += countSum_tDBOutput_2;

						insertedCount_tDBOutput_2 += countSum_tDBOutput_2;

					}

				} catch (java.sql.BatchUpdateException e) {
					globalMap.put(currentComponent + "_ERROR_MESSAGE", e.getMessage());

					int countSum_tDBOutput_2 = 0;
					for (int countEach_tDBOutput_2 : e.getUpdateCounts()) {
						countSum_tDBOutput_2 += (countEach_tDBOutput_2 < 0 ? 0 : countEach_tDBOutput_2);
					}
					rowsToCommitCount_tDBOutput_2 += countSum_tDBOutput_2;

					insertedCount_tDBOutput_2 += countSum_tDBOutput_2;

					System.err.println(e.getMessage());

				}
				batchSizeCounter_tDBOutput_2 = 0;

				if (pstmt_tDBOutput_2 != null) {

					pstmt_tDBOutput_2.close();
					resourceMap.remove("pstmt_tDBOutput_2");

				}
				resourceMap.put("statementClosed_tDBOutput_2", true);
				if (commitCounter_tDBOutput_2 > 0 && rowsToCommitCount_tDBOutput_2 != 0) {

				}
				conn_tDBOutput_2.commit();
				if (commitCounter_tDBOutput_2 > 0 && rowsToCommitCount_tDBOutput_2 != 0) {

					rowsToCommitCount_tDBOutput_2 = 0;
				}
				commitCounter_tDBOutput_2 = 0;

				conn_tDBOutput_2.close();

				resourceMap.put("finish_tDBOutput_2", true);

				nb_line_deleted_tDBOutput_2 = nb_line_deleted_tDBOutput_2 + deletedCount_tDBOutput_2;
				nb_line_update_tDBOutput_2 = nb_line_update_tDBOutput_2 + updatedCount_tDBOutput_2;
				nb_line_inserted_tDBOutput_2 = nb_line_inserted_tDBOutput_2 + insertedCount_tDBOutput_2;
				nb_line_rejected_tDBOutput_2 = nb_line_rejected_tDBOutput_2 + rejectedCount_tDBOutput_2;

				globalMap.put("tDBOutput_2_NB_LINE", nb_line_tDBOutput_2);
				globalMap.put("tDBOutput_2_NB_LINE_UPDATED", nb_line_update_tDBOutput_2);
				globalMap.put("tDBOutput_2_NB_LINE_INSERTED", nb_line_inserted_tDBOutput_2);
				globalMap.put("tDBOutput_2_NB_LINE_DELETED", nb_line_deleted_tDBOutput_2);
				globalMap.put("tDBOutput_2_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_2);

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "duplicated");
				}

				ok_Hash.put("tDBOutput_2", true);
				end_Hash.put("tDBOutput_2", System.currentTimeMillis());

				/**
				 * [tDBOutput_2 end ] stop
				 */

				/**
				 * [tFileOutputDelimited_1 end ] start
				 */

				currentComponent = "tFileOutputDelimited_1";

				if (outtFileOutputDelimited_1 != null) {
					outtFileOutputDelimited_1.flush();
					outtFileOutputDelimited_1.close();
				}

				globalMap.put("tFileOutputDelimited_1_NB_LINE", nb_line_tFileOutputDelimited_1);
				globalMap.put("tFileOutputDelimited_1_FILE_NAME", fileName_tFileOutputDelimited_1);

				resourceMap.put("finish_tFileOutputDelimited_1", true);

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "output");
				}

				ok_Hash.put("tFileOutputDelimited_1", true);
				end_Hash.put("tFileOutputDelimited_1", System.currentTimeMillis());

				/**
				 * [tFileOutputDelimited_1 end ] stop
				 */

			} // end the resume

			if (resumeEntryMethodName == null || globalResumeTicket) {
				resumeUtil.addLog("CHECKPOINT", "CONNECTION:SUBJOB_OK:tFileInputDelimited_2:OnSubjobOk", "",
						Thread.currentThread().getId() + "", "", "", "", "", "");
			}

			if (execStat) {
				runStat.updateStatOnConnection("OnSubjobOk2", 0, "ok");
			}

			tFileInputDelimited_3Process(globalMap);

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			// free memory for "tMap_2"
			globalMap.remove("tHash_Lookup_row5");

			try {

				/**
				 * [tFileInputDelimited_2 finally ] start
				 */

				currentComponent = "tFileInputDelimited_2";

				/**
				 * [tFileInputDelimited_2 finally ] stop
				 */

				/**
				 * [tMap_2 finally ] start
				 */

				currentComponent = "tMap_2";

				/**
				 * [tMap_2 finally ] stop
				 */

				/**
				 * [tDBOutput_2 finally ] start
				 */

				currentComponent = "tDBOutput_2";

				try {
					if (resourceMap.get("statementClosed_tDBOutput_2") == null) {
						java.sql.PreparedStatement pstmtToClose_tDBOutput_2 = null;
						if ((pstmtToClose_tDBOutput_2 = (java.sql.PreparedStatement) resourceMap
								.remove("pstmt_tDBOutput_2")) != null) {
							pstmtToClose_tDBOutput_2.close();
						}
					}
				} finally {
					if (resourceMap.get("finish_tDBOutput_2") == null) {
						java.sql.Connection ctn_tDBOutput_2 = null;
						if ((ctn_tDBOutput_2 = (java.sql.Connection) resourceMap.get("conn_tDBOutput_2")) != null) {
							try {
								ctn_tDBOutput_2.close();
							} catch (java.sql.SQLException sqlEx_tDBOutput_2) {
								String errorMessage_tDBOutput_2 = "failed to close the connection in tDBOutput_2 :"
										+ sqlEx_tDBOutput_2.getMessage();
								System.err.println(errorMessage_tDBOutput_2);
							}
						}
					}
				}

				/**
				 * [tDBOutput_2 finally ] stop
				 */

				/**
				 * [tFileOutputDelimited_1 finally ] start
				 */

				currentComponent = "tFileOutputDelimited_1";

				if (resourceMap.get("finish_tFileOutputDelimited_1") == null) {

					java.io.Writer outtFileOutputDelimited_1 = (java.io.Writer) resourceMap
							.get("out_tFileOutputDelimited_1");
					if (outtFileOutputDelimited_1 != null) {
						outtFileOutputDelimited_1.flush();
						outtFileOutputDelimited_1.close();
					}

				}

				/**
				 * [tFileOutputDelimited_1 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tFileInputDelimited_2_SUBPROCESS_STATE", 1);
	}

	public static class duplicated1Struct implements routines.system.IPersistableRow<duplicated1Struct> {
		final static byte[] commonByteArrayLock_GROMED_dump_gros_med_brut = new byte[0];
		static byte[] commonByteArray_GROMED_dump_gros_med_brut = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public int id;

		public int getId() {
			return this.id;
		}

		public String codeCIS;

		public String getCodeCIS() {
			return this.codeCIS;
		}

		public String codeCIP7;

		public String getCodeCIP7() {
			return this.codeCIP7;
		}

		public String libellePresentation;

		public String getLibellePresentation() {
			return this.libellePresentation;
		}

		public String statutAdministratifPresentation;

		public String getStatutAdministratifPresentation() {
			return this.statutAdministratifPresentation;
		}

		public String etatCommercialisation;

		public String getEtatCommercialisation() {
			return this.etatCommercialisation;
		}

		public String dateDeclarationCommercialisation;

		public String getDateDeclarationCommercialisation() {
			return this.dateDeclarationCommercialisation;
		}

		public String codeCIP13;

		public String getCodeCIP13() {
			return this.codeCIP13;
		}

		public String agrementCollectivites;

		public String getAgrementCollectivites() {
			return this.agrementCollectivites;
		}

		public String tauxRemboursement;

		public String getTauxRemboursement() {
			return this.tauxRemboursement;
		}

		public String prix;

		public String getPrix() {
			return this.prix;
		}

		public String droitRemboursement;

		public String getDroitRemboursement() {
			return this.droitRemboursement;
		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + (int) this.id;

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final duplicated1Struct other = (duplicated1Struct) obj;

			if (this.id != other.id)
				return false;

			return true;
		}

		public void copyDataTo(duplicated1Struct other) {

			other.id = this.id;
			other.codeCIS = this.codeCIS;
			other.codeCIP7 = this.codeCIP7;
			other.libellePresentation = this.libellePresentation;
			other.statutAdministratifPresentation = this.statutAdministratifPresentation;
			other.etatCommercialisation = this.etatCommercialisation;
			other.dateDeclarationCommercialisation = this.dateDeclarationCommercialisation;
			other.codeCIP13 = this.codeCIP13;
			other.agrementCollectivites = this.agrementCollectivites;
			other.tauxRemboursement = this.tauxRemboursement;
			other.prix = this.prix;
			other.droitRemboursement = this.droitRemboursement;

		}

		public void copyKeysDataTo(duplicated1Struct other) {

			other.id = this.id;

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_GROMED_dump_gros_med_brut.length) {
					if (length < 1024 && commonByteArray_GROMED_dump_gros_med_brut.length == 0) {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[1024];
					} else {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_GROMED_dump_gros_med_brut, 0, length);
				strReturn = new String(commonByteArray_GROMED_dump_gros_med_brut, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_GROMED_dump_gros_med_brut.length) {
					if (length < 1024 && commonByteArray_GROMED_dump_gros_med_brut.length == 0) {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[1024];
					} else {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_GROMED_dump_gros_med_brut, 0, length);
				strReturn = new String(commonByteArray_GROMED_dump_gros_med_brut, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_GROMED_dump_gros_med_brut) {

				try {

					int length = 0;

					this.id = dis.readInt();

					this.codeCIS = readString(dis);

					this.codeCIP7 = readString(dis);

					this.libellePresentation = readString(dis);

					this.statutAdministratifPresentation = readString(dis);

					this.etatCommercialisation = readString(dis);

					this.dateDeclarationCommercialisation = readString(dis);

					this.codeCIP13 = readString(dis);

					this.agrementCollectivites = readString(dis);

					this.tauxRemboursement = readString(dis);

					this.prix = readString(dis);

					this.droitRemboursement = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_GROMED_dump_gros_med_brut) {

				try {

					int length = 0;

					this.id = dis.readInt();

					this.codeCIS = readString(dis);

					this.codeCIP7 = readString(dis);

					this.libellePresentation = readString(dis);

					this.statutAdministratifPresentation = readString(dis);

					this.etatCommercialisation = readString(dis);

					this.dateDeclarationCommercialisation = readString(dis);

					this.codeCIP13 = readString(dis);

					this.agrementCollectivites = readString(dis);

					this.tauxRemboursement = readString(dis);

					this.prix = readString(dis);

					this.droitRemboursement = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// int

				dos.writeInt(this.id);

				// String

				writeString(this.codeCIS, dos);

				// String

				writeString(this.codeCIP7, dos);

				// String

				writeString(this.libellePresentation, dos);

				// String

				writeString(this.statutAdministratifPresentation, dos);

				// String

				writeString(this.etatCommercialisation, dos);

				// String

				writeString(this.dateDeclarationCommercialisation, dos);

				// String

				writeString(this.codeCIP13, dos);

				// String

				writeString(this.agrementCollectivites, dos);

				// String

				writeString(this.tauxRemboursement, dos);

				// String

				writeString(this.prix, dos);

				// String

				writeString(this.droitRemboursement, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// int

				dos.writeInt(this.id);

				// String

				writeString(this.codeCIS, dos);

				// String

				writeString(this.codeCIP7, dos);

				// String

				writeString(this.libellePresentation, dos);

				// String

				writeString(this.statutAdministratifPresentation, dos);

				// String

				writeString(this.etatCommercialisation, dos);

				// String

				writeString(this.dateDeclarationCommercialisation, dos);

				// String

				writeString(this.codeCIP13, dos);

				// String

				writeString(this.agrementCollectivites, dos);

				// String

				writeString(this.tauxRemboursement, dos);

				// String

				writeString(this.prix, dos);

				// String

				writeString(this.droitRemboursement, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("id=" + String.valueOf(id));
			sb.append(",codeCIS=" + codeCIS);
			sb.append(",codeCIP7=" + codeCIP7);
			sb.append(",libellePresentation=" + libellePresentation);
			sb.append(",statutAdministratifPresentation=" + statutAdministratifPresentation);
			sb.append(",etatCommercialisation=" + etatCommercialisation);
			sb.append(",dateDeclarationCommercialisation=" + dateDeclarationCommercialisation);
			sb.append(",codeCIP13=" + codeCIP13);
			sb.append(",agrementCollectivites=" + agrementCollectivites);
			sb.append(",tauxRemboursement=" + tauxRemboursement);
			sb.append(",prix=" + prix);
			sb.append(",droitRemboursement=" + droitRemboursement);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(duplicated1Struct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.id, other.id);
			if (returnValue != 0) {
				return returnValue;
			}

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class rejectStruct implements routines.system.IPersistableRow<rejectStruct> {
		final static byte[] commonByteArrayLock_GROMED_dump_gros_med_brut = new byte[0];
		static byte[] commonByteArray_GROMED_dump_gros_med_brut = new byte[0];

		public String codeCIS;

		public String getCodeCIS() {
			return this.codeCIS;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_GROMED_dump_gros_med_brut.length) {
					if (length < 1024 && commonByteArray_GROMED_dump_gros_med_brut.length == 0) {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[1024];
					} else {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_GROMED_dump_gros_med_brut, 0, length);
				strReturn = new String(commonByteArray_GROMED_dump_gros_med_brut, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_GROMED_dump_gros_med_brut.length) {
					if (length < 1024 && commonByteArray_GROMED_dump_gros_med_brut.length == 0) {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[1024];
					} else {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_GROMED_dump_gros_med_brut, 0, length);
				strReturn = new String(commonByteArray_GROMED_dump_gros_med_brut, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_GROMED_dump_gros_med_brut) {

				try {

					int length = 0;

					this.codeCIS = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_GROMED_dump_gros_med_brut) {

				try {

					int length = 0;

					this.codeCIS = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.codeCIS, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.codeCIS, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("codeCIS=" + codeCIS);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(rejectStruct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class row2Struct implements routines.system.IPersistableRow<row2Struct> {
		final static byte[] commonByteArrayLock_GROMED_dump_gros_med_brut = new byte[0];
		static byte[] commonByteArray_GROMED_dump_gros_med_brut = new byte[0];

		public String codeCIS;

		public String getCodeCIS() {
			return this.codeCIS;
		}

		public String codeCIP7;

		public String getCodeCIP7() {
			return this.codeCIP7;
		}

		public String libelle;

		public String getLibelle() {
			return this.libelle;
		}

		public String statusAdm;

		public String getStatusAdm() {
			return this.statusAdm;
		}

		public String etat;

		public String getEtat() {
			return this.etat;
		}

		public String date;

		public String getDate() {
			return this.date;
		}

		public String codeCIP13;

		public String getCodeCIP13() {
			return this.codeCIP13;
		}

		public String agrement;

		public String getAgrement() {
			return this.agrement;
		}

		public String taux;

		public String getTaux() {
			return this.taux;
		}

		public String prix;

		public String getPrix() {
			return this.prix;
		}

		public String texte;

		public String getTexte() {
			return this.texte;
		}

		public String Column11;

		public String getColumn11() {
			return this.Column11;
		}

		public String Column12;

		public String getColumn12() {
			return this.Column12;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_GROMED_dump_gros_med_brut.length) {
					if (length < 1024 && commonByteArray_GROMED_dump_gros_med_brut.length == 0) {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[1024];
					} else {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_GROMED_dump_gros_med_brut, 0, length);
				strReturn = new String(commonByteArray_GROMED_dump_gros_med_brut, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_GROMED_dump_gros_med_brut.length) {
					if (length < 1024 && commonByteArray_GROMED_dump_gros_med_brut.length == 0) {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[1024];
					} else {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_GROMED_dump_gros_med_brut, 0, length);
				strReturn = new String(commonByteArray_GROMED_dump_gros_med_brut, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_GROMED_dump_gros_med_brut) {

				try {

					int length = 0;

					this.codeCIS = readString(dis);

					this.codeCIP7 = readString(dis);

					this.libelle = readString(dis);

					this.statusAdm = readString(dis);

					this.etat = readString(dis);

					this.date = readString(dis);

					this.codeCIP13 = readString(dis);

					this.agrement = readString(dis);

					this.taux = readString(dis);

					this.prix = readString(dis);

					this.texte = readString(dis);

					this.Column11 = readString(dis);

					this.Column12 = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_GROMED_dump_gros_med_brut) {

				try {

					int length = 0;

					this.codeCIS = readString(dis);

					this.codeCIP7 = readString(dis);

					this.libelle = readString(dis);

					this.statusAdm = readString(dis);

					this.etat = readString(dis);

					this.date = readString(dis);

					this.codeCIP13 = readString(dis);

					this.agrement = readString(dis);

					this.taux = readString(dis);

					this.prix = readString(dis);

					this.texte = readString(dis);

					this.Column11 = readString(dis);

					this.Column12 = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.codeCIS, dos);

				// String

				writeString(this.codeCIP7, dos);

				// String

				writeString(this.libelle, dos);

				// String

				writeString(this.statusAdm, dos);

				// String

				writeString(this.etat, dos);

				// String

				writeString(this.date, dos);

				// String

				writeString(this.codeCIP13, dos);

				// String

				writeString(this.agrement, dos);

				// String

				writeString(this.taux, dos);

				// String

				writeString(this.prix, dos);

				// String

				writeString(this.texte, dos);

				// String

				writeString(this.Column11, dos);

				// String

				writeString(this.Column12, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.codeCIS, dos);

				// String

				writeString(this.codeCIP7, dos);

				// String

				writeString(this.libelle, dos);

				// String

				writeString(this.statusAdm, dos);

				// String

				writeString(this.etat, dos);

				// String

				writeString(this.date, dos);

				// String

				writeString(this.codeCIP13, dos);

				// String

				writeString(this.agrement, dos);

				// String

				writeString(this.taux, dos);

				// String

				writeString(this.prix, dos);

				// String

				writeString(this.texte, dos);

				// String

				writeString(this.Column11, dos);

				// String

				writeString(this.Column12, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("codeCIS=" + codeCIS);
			sb.append(",codeCIP7=" + codeCIP7);
			sb.append(",libelle=" + libelle);
			sb.append(",statusAdm=" + statusAdm);
			sb.append(",etat=" + etat);
			sb.append(",date=" + date);
			sb.append(",codeCIP13=" + codeCIP13);
			sb.append(",agrement=" + agrement);
			sb.append(",taux=" + taux);
			sb.append(",prix=" + prix);
			sb.append(",texte=" + texte);
			sb.append(",Column11=" + Column11);
			sb.append(",Column12=" + Column12);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row2Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class after_tFileInputDelimited_3Struct
			implements routines.system.IPersistableRow<after_tFileInputDelimited_3Struct> {
		final static byte[] commonByteArrayLock_GROMED_dump_gros_med_brut = new byte[0];
		static byte[] commonByteArray_GROMED_dump_gros_med_brut = new byte[0];

		public String codeCIS;

		public String getCodeCIS() {
			return this.codeCIS;
		}

		public String codeCIP7;

		public String getCodeCIP7() {
			return this.codeCIP7;
		}

		public String libelle;

		public String getLibelle() {
			return this.libelle;
		}

		public String statusAdm;

		public String getStatusAdm() {
			return this.statusAdm;
		}

		public String etat;

		public String getEtat() {
			return this.etat;
		}

		public String date;

		public String getDate() {
			return this.date;
		}

		public String codeCIP13;

		public String getCodeCIP13() {
			return this.codeCIP13;
		}

		public String agrement;

		public String getAgrement() {
			return this.agrement;
		}

		public String taux;

		public String getTaux() {
			return this.taux;
		}

		public String prix;

		public String getPrix() {
			return this.prix;
		}

		public String texte;

		public String getTexte() {
			return this.texte;
		}

		public String Column11;

		public String getColumn11() {
			return this.Column11;
		}

		public String Column12;

		public String getColumn12() {
			return this.Column12;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_GROMED_dump_gros_med_brut.length) {
					if (length < 1024 && commonByteArray_GROMED_dump_gros_med_brut.length == 0) {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[1024];
					} else {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_GROMED_dump_gros_med_brut, 0, length);
				strReturn = new String(commonByteArray_GROMED_dump_gros_med_brut, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_GROMED_dump_gros_med_brut.length) {
					if (length < 1024 && commonByteArray_GROMED_dump_gros_med_brut.length == 0) {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[1024];
					} else {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_GROMED_dump_gros_med_brut, 0, length);
				strReturn = new String(commonByteArray_GROMED_dump_gros_med_brut, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_GROMED_dump_gros_med_brut) {

				try {

					int length = 0;

					this.codeCIS = readString(dis);

					this.codeCIP7 = readString(dis);

					this.libelle = readString(dis);

					this.statusAdm = readString(dis);

					this.etat = readString(dis);

					this.date = readString(dis);

					this.codeCIP13 = readString(dis);

					this.agrement = readString(dis);

					this.taux = readString(dis);

					this.prix = readString(dis);

					this.texte = readString(dis);

					this.Column11 = readString(dis);

					this.Column12 = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_GROMED_dump_gros_med_brut) {

				try {

					int length = 0;

					this.codeCIS = readString(dis);

					this.codeCIP7 = readString(dis);

					this.libelle = readString(dis);

					this.statusAdm = readString(dis);

					this.etat = readString(dis);

					this.date = readString(dis);

					this.codeCIP13 = readString(dis);

					this.agrement = readString(dis);

					this.taux = readString(dis);

					this.prix = readString(dis);

					this.texte = readString(dis);

					this.Column11 = readString(dis);

					this.Column12 = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.codeCIS, dos);

				// String

				writeString(this.codeCIP7, dos);

				// String

				writeString(this.libelle, dos);

				// String

				writeString(this.statusAdm, dos);

				// String

				writeString(this.etat, dos);

				// String

				writeString(this.date, dos);

				// String

				writeString(this.codeCIP13, dos);

				// String

				writeString(this.agrement, dos);

				// String

				writeString(this.taux, dos);

				// String

				writeString(this.prix, dos);

				// String

				writeString(this.texte, dos);

				// String

				writeString(this.Column11, dos);

				// String

				writeString(this.Column12, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.codeCIS, dos);

				// String

				writeString(this.codeCIP7, dos);

				// String

				writeString(this.libelle, dos);

				// String

				writeString(this.statusAdm, dos);

				// String

				writeString(this.etat, dos);

				// String

				writeString(this.date, dos);

				// String

				writeString(this.codeCIP13, dos);

				// String

				writeString(this.agrement, dos);

				// String

				writeString(this.taux, dos);

				// String

				writeString(this.prix, dos);

				// String

				writeString(this.texte, dos);

				// String

				writeString(this.Column11, dos);

				// String

				writeString(this.Column12, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("codeCIS=" + codeCIS);
			sb.append(",codeCIP7=" + codeCIP7);
			sb.append(",libelle=" + libelle);
			sb.append(",statusAdm=" + statusAdm);
			sb.append(",etat=" + etat);
			sb.append(",date=" + date);
			sb.append(",codeCIP13=" + codeCIP13);
			sb.append(",agrement=" + agrement);
			sb.append(",taux=" + taux);
			sb.append(",prix=" + prix);
			sb.append(",texte=" + texte);
			sb.append(",Column11=" + Column11);
			sb.append(",Column12=" + Column12);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(after_tFileInputDelimited_3Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public void tFileInputDelimited_3Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tFileInputDelimited_3_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				tDBInput_2Process(globalMap);

				row2Struct row2 = new row2Struct();
				duplicated1Struct duplicated1 = new duplicated1Struct();
				rejectStruct reject = new rejectStruct();

				/**
				 * [tDBOutput_3 begin ] start
				 */

				ok_Hash.put("tDBOutput_3", false);
				start_Hash.put("tDBOutput_3", System.currentTimeMillis());

				currentComponent = "tDBOutput_3";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "duplicated1");
				}

				int tos_count_tDBOutput_3 = 0;

				int nb_line_tDBOutput_3 = 0;
				int nb_line_update_tDBOutput_3 = 0;
				int nb_line_inserted_tDBOutput_3 = 0;
				int nb_line_deleted_tDBOutput_3 = 0;
				int nb_line_rejected_tDBOutput_3 = 0;

				int deletedCount_tDBOutput_3 = 0;
				int updatedCount_tDBOutput_3 = 0;
				int insertedCount_tDBOutput_3 = 0;
				int rowsToCommitCount_tDBOutput_3 = 0;
				int rejectedCount_tDBOutput_3 = 0;

				String tableName_tDBOutput_3 = "cis_cip_bdpm";
				boolean whetherReject_tDBOutput_3 = false;

				java.util.Calendar calendar_tDBOutput_3 = java.util.Calendar.getInstance();
				calendar_tDBOutput_3.set(1, 0, 1, 0, 0, 0);
				long year1_tDBOutput_3 = calendar_tDBOutput_3.getTime().getTime();
				calendar_tDBOutput_3.set(10000, 0, 1, 0, 0, 0);
				long year10000_tDBOutput_3 = calendar_tDBOutput_3.getTime().getTime();
				long date_tDBOutput_3;

				java.sql.Connection conn_tDBOutput_3 = null;

				String properties_tDBOutput_3 = context.gros_med_brut1_AdditionalParams;
				if (properties_tDBOutput_3 == null || properties_tDBOutput_3.trim().length() == 0) {
					properties_tDBOutput_3 = "rewriteBatchedStatements=true&allowLoadLocalInfile=true";
				} else {
					if (!properties_tDBOutput_3.contains("rewriteBatchedStatements=")) {
						properties_tDBOutput_3 += "&rewriteBatchedStatements=true";
					}

					if (!properties_tDBOutput_3.contains("allowLoadLocalInfile=")) {
						properties_tDBOutput_3 += "&allowLoadLocalInfile=true";
					}
				}

				String url_tDBOutput_3 = "jdbc:mariadb://" + context.gros_med_brut1_Server + ":"
						+ context.gros_med_brut1_Port + "/" + context.gros_med_brut1_Database + "?"
						+ properties_tDBOutput_3;

				String driverClass_tDBOutput_3 = "org.mariadb.jdbc.Driver";

				String dbUser_tDBOutput_3 = context.gros_med_brut1_Login;

				final String decryptedPassword_tDBOutput_3 = context.gros_med_brut1_Password;

				String dbPwd_tDBOutput_3 = decryptedPassword_tDBOutput_3;
				java.lang.Class.forName(driverClass_tDBOutput_3);

				conn_tDBOutput_3 = java.sql.DriverManager.getConnection(url_tDBOutput_3, dbUser_tDBOutput_3,
						dbPwd_tDBOutput_3);

				resourceMap.put("conn_tDBOutput_3", conn_tDBOutput_3);
				conn_tDBOutput_3.setAutoCommit(false);
				int commitEvery_tDBOutput_3 = 10000;
				int commitCounter_tDBOutput_3 = 0;

				int count_tDBOutput_3 = 0;

				try (java.sql.Statement stmtClear_tDBOutput_3 = conn_tDBOutput_3.createStatement()) {
					stmtClear_tDBOutput_3.executeUpdate("DELETE FROM `" + tableName_tDBOutput_3 + "`");
				}

				String insert_tDBOutput_3 = "INSERT INTO `" + "cis_cip_bdpm"
						+ "` (`id`,`codeCIS`,`codeCIP7`,`libellePresentation`,`statutAdministratifPresentation`,`etatCommercialisation`,`dateDeclarationCommercialisation`,`codeCIP13`,`agrementCollectivites`,`tauxRemboursement`,`prix`,`droitRemboursement`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
				int batchSize_tDBOutput_3 = 100;
				int batchSizeCounter_tDBOutput_3 = 0;

				java.sql.PreparedStatement pstmt_tDBOutput_3 = conn_tDBOutput_3.prepareStatement(insert_tDBOutput_3);
				resourceMap.put("pstmt_tDBOutput_3", pstmt_tDBOutput_3);

				/**
				 * [tDBOutput_3 begin ] stop
				 */

				/**
				 * [tFileOutputDelimited_2 begin ] start
				 */

				ok_Hash.put("tFileOutputDelimited_2", false);
				start_Hash.put("tFileOutputDelimited_2", System.currentTimeMillis());

				currentComponent = "tFileOutputDelimited_2";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "reject");
				}

				int tos_count_tFileOutputDelimited_2 = 0;

				String fileName_tFileOutputDelimited_2 = "";
				fileName_tFileOutputDelimited_2 = (new java.io.File(
						context.source + "log/cis_cip_bdpm_Unknow_Primarykey.log")).getAbsolutePath().replace("\\",
								"/");
				String fullName_tFileOutputDelimited_2 = null;
				String extension_tFileOutputDelimited_2 = null;
				String directory_tFileOutputDelimited_2 = null;
				if ((fileName_tFileOutputDelimited_2.indexOf("/") != -1)) {
					if (fileName_tFileOutputDelimited_2.lastIndexOf(".") < fileName_tFileOutputDelimited_2
							.lastIndexOf("/")) {
						fullName_tFileOutputDelimited_2 = fileName_tFileOutputDelimited_2;
						extension_tFileOutputDelimited_2 = "";
					} else {
						fullName_tFileOutputDelimited_2 = fileName_tFileOutputDelimited_2.substring(0,
								fileName_tFileOutputDelimited_2.lastIndexOf("."));
						extension_tFileOutputDelimited_2 = fileName_tFileOutputDelimited_2
								.substring(fileName_tFileOutputDelimited_2.lastIndexOf("."));
					}
					directory_tFileOutputDelimited_2 = fileName_tFileOutputDelimited_2.substring(0,
							fileName_tFileOutputDelimited_2.lastIndexOf("/"));
				} else {
					if (fileName_tFileOutputDelimited_2.lastIndexOf(".") != -1) {
						fullName_tFileOutputDelimited_2 = fileName_tFileOutputDelimited_2.substring(0,
								fileName_tFileOutputDelimited_2.lastIndexOf("."));
						extension_tFileOutputDelimited_2 = fileName_tFileOutputDelimited_2
								.substring(fileName_tFileOutputDelimited_2.lastIndexOf("."));
					} else {
						fullName_tFileOutputDelimited_2 = fileName_tFileOutputDelimited_2;
						extension_tFileOutputDelimited_2 = "";
					}
					directory_tFileOutputDelimited_2 = "";
				}
				boolean isFileGenerated_tFileOutputDelimited_2 = true;
				java.io.File filetFileOutputDelimited_2 = new java.io.File(fileName_tFileOutputDelimited_2);
				globalMap.put("tFileOutputDelimited_2_FILE_NAME", fileName_tFileOutputDelimited_2);
				int nb_line_tFileOutputDelimited_2 = 0;
				int splitedFileNo_tFileOutputDelimited_2 = 0;
				int currentRow_tFileOutputDelimited_2 = 0;

				final String OUT_DELIM_tFileOutputDelimited_2 = /** Start field tFileOutputDelimited_2:FIELDSEPARATOR */
						";"/** End field tFileOutputDelimited_2:FIELDSEPARATOR */
				;

				final String OUT_DELIM_ROWSEP_tFileOutputDelimited_2 = /**
																		 * Start field
																		 * tFileOutputDelimited_2:ROWSEPARATOR
																		 */
						"\n"/** End field tFileOutputDelimited_2:ROWSEPARATOR */
				;

				// create directory only if not exists
				if (directory_tFileOutputDelimited_2 != null && directory_tFileOutputDelimited_2.trim().length() != 0) {
					java.io.File dir_tFileOutputDelimited_2 = new java.io.File(directory_tFileOutputDelimited_2);
					if (!dir_tFileOutputDelimited_2.exists()) {
						dir_tFileOutputDelimited_2.mkdirs();
					}
				}

				// routines.system.Row
				java.io.Writer outtFileOutputDelimited_2 = null;

				java.io.File fileToDelete_tFileOutputDelimited_2 = new java.io.File(fileName_tFileOutputDelimited_2);
				if (fileToDelete_tFileOutputDelimited_2.exists()) {
					fileToDelete_tFileOutputDelimited_2.delete();
				}
				outtFileOutputDelimited_2 = new java.io.BufferedWriter(new java.io.OutputStreamWriter(
						new java.io.FileOutputStream(fileName_tFileOutputDelimited_2, false), "ISO-8859-15"));

				resourceMap.put("out_tFileOutputDelimited_2", outtFileOutputDelimited_2);
				resourceMap.put("nb_line_tFileOutputDelimited_2", nb_line_tFileOutputDelimited_2);

				/**
				 * [tFileOutputDelimited_2 begin ] stop
				 */

				/**
				 * [tMap_3 begin ] start
				 */

				ok_Hash.put("tMap_3", false);
				start_Hash.put("tMap_3", System.currentTimeMillis());

				currentComponent = "tMap_3";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row2");
				}

				int tos_count_tMap_3 = 0;

// ###############################
// # Lookup's keys initialization

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row4Struct> tHash_Lookup_row4 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row4Struct>) ((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row4Struct>) globalMap
						.get("tHash_Lookup_row4"));

				row4Struct row4HashKey = new row4Struct();
				row4Struct row4Default = new row4Struct();
// ###############################        

// ###############################
// # Vars initialization
				class Var__tMap_3__Struct {
					String tauxRebourseement;
				}
				Var__tMap_3__Struct Var__tMap_3 = new Var__tMap_3__Struct();
// ###############################

// ###############################
// # Outputs initialization
				duplicated1Struct duplicated1_tmp = new duplicated1Struct();
				rejectStruct reject_tmp = new rejectStruct();
// ###############################

				/**
				 * [tMap_3 begin ] stop
				 */

				/**
				 * [tFileInputDelimited_3 begin ] start
				 */

				ok_Hash.put("tFileInputDelimited_3", false);
				start_Hash.put("tFileInputDelimited_3", System.currentTimeMillis());

				currentComponent = "tFileInputDelimited_3";

				int tos_count_tFileInputDelimited_3 = 0;

				final routines.system.RowState rowstate_tFileInputDelimited_3 = new routines.system.RowState();

				int nb_line_tFileInputDelimited_3 = 0;
				org.talend.fileprocess.FileInputDelimited fid_tFileInputDelimited_3 = null;
				int limit_tFileInputDelimited_3 = -1;
				try {

					Object filename_tFileInputDelimited_3 = "C:/Users/Ethan/Documents/workspace/GROMED/data/fichiers/CIS_CIP_bdpm.txt";
					if (filename_tFileInputDelimited_3 instanceof java.io.InputStream) {

						int footer_value_tFileInputDelimited_3 = 0, random_value_tFileInputDelimited_3 = -1;
						if (footer_value_tFileInputDelimited_3 > 0 || random_value_tFileInputDelimited_3 > 0) {
							throw new java.lang.Exception(
									"When the input source is a stream,footer and random shouldn't be bigger than 0.");
						}

					}
					try {
						fid_tFileInputDelimited_3 = new org.talend.fileprocess.FileInputDelimited(
								"C:/Users/Ethan/Documents/workspace/GROMED/data/fichiers/CIS_CIP_bdpm.txt",
								"ISO-8859-15", "\t", "\n", false, 0, 0, limit_tFileInputDelimited_3, -1, false);
					} catch (java.lang.Exception e) {
						globalMap.put("tFileInputDelimited_3_ERROR_MESSAGE", e.getMessage());

						System.err.println(e.getMessage());

					}

					while (fid_tFileInputDelimited_3 != null && fid_tFileInputDelimited_3.nextRecord()) {
						rowstate_tFileInputDelimited_3.reset();

						row2 = null;

						boolean whetherReject_tFileInputDelimited_3 = false;
						row2 = new row2Struct();
						try {

							int columnIndexWithD_tFileInputDelimited_3 = 0;

							columnIndexWithD_tFileInputDelimited_3 = 0;

							row2.codeCIS = fid_tFileInputDelimited_3.get(columnIndexWithD_tFileInputDelimited_3);

							columnIndexWithD_tFileInputDelimited_3 = 1;

							row2.codeCIP7 = fid_tFileInputDelimited_3.get(columnIndexWithD_tFileInputDelimited_3);

							columnIndexWithD_tFileInputDelimited_3 = 2;

							row2.libelle = fid_tFileInputDelimited_3.get(columnIndexWithD_tFileInputDelimited_3);

							columnIndexWithD_tFileInputDelimited_3 = 3;

							row2.statusAdm = fid_tFileInputDelimited_3.get(columnIndexWithD_tFileInputDelimited_3);

							columnIndexWithD_tFileInputDelimited_3 = 4;

							row2.etat = fid_tFileInputDelimited_3.get(columnIndexWithD_tFileInputDelimited_3);

							columnIndexWithD_tFileInputDelimited_3 = 5;

							row2.date = fid_tFileInputDelimited_3.get(columnIndexWithD_tFileInputDelimited_3);

							columnIndexWithD_tFileInputDelimited_3 = 6;

							row2.codeCIP13 = fid_tFileInputDelimited_3.get(columnIndexWithD_tFileInputDelimited_3);

							columnIndexWithD_tFileInputDelimited_3 = 7;

							row2.agrement = fid_tFileInputDelimited_3.get(columnIndexWithD_tFileInputDelimited_3);

							columnIndexWithD_tFileInputDelimited_3 = 8;

							row2.taux = fid_tFileInputDelimited_3.get(columnIndexWithD_tFileInputDelimited_3);

							columnIndexWithD_tFileInputDelimited_3 = 9;

							row2.prix = fid_tFileInputDelimited_3.get(columnIndexWithD_tFileInputDelimited_3);

							columnIndexWithD_tFileInputDelimited_3 = 10;

							row2.texte = fid_tFileInputDelimited_3.get(columnIndexWithD_tFileInputDelimited_3);

							columnIndexWithD_tFileInputDelimited_3 = 11;

							row2.Column11 = fid_tFileInputDelimited_3.get(columnIndexWithD_tFileInputDelimited_3);

							columnIndexWithD_tFileInputDelimited_3 = 12;

							row2.Column12 = fid_tFileInputDelimited_3.get(columnIndexWithD_tFileInputDelimited_3);

							if (rowstate_tFileInputDelimited_3.getException() != null) {
								throw rowstate_tFileInputDelimited_3.getException();
							}

						} catch (java.lang.Exception e) {
							globalMap.put("tFileInputDelimited_3_ERROR_MESSAGE", e.getMessage());
							whetherReject_tFileInputDelimited_3 = true;

							System.err.println(e.getMessage());
							row2 = null;

						}

						/**
						 * [tFileInputDelimited_3 begin ] stop
						 */

						/**
						 * [tFileInputDelimited_3 main ] start
						 */

						currentComponent = "tFileInputDelimited_3";

						tos_count_tFileInputDelimited_3++;

						/**
						 * [tFileInputDelimited_3 main ] stop
						 */

						/**
						 * [tFileInputDelimited_3 process_data_begin ] start
						 */

						currentComponent = "tFileInputDelimited_3";

						/**
						 * [tFileInputDelimited_3 process_data_begin ] stop
						 */
// Start of branch "row2"
						if (row2 != null) {

							/**
							 * [tMap_3 main ] start
							 */

							currentComponent = "tMap_3";

							if (execStat) {
								runStat.updateStatOnConnection(iterateId, 1, 1

										, "row2"

								);
							}

							boolean hasCasePrimitiveKeyWithNull_tMap_3 = false;

							// ###############################
							// # Input tables (lookups)
							boolean rejectedInnerJoin_tMap_3 = false;
							boolean mainRowRejected_tMap_3 = false;

							///////////////////////////////////////////////
							// Starting Lookup Table "row4"
							///////////////////////////////////////////////

							boolean forceLooprow4 = false;

							row4Struct row4ObjectFromLookup = null;

							if (!rejectedInnerJoin_tMap_3) { // G_TM_M_020

								hasCasePrimitiveKeyWithNull_tMap_3 = false;

								row4HashKey.codeCIS = row2.codeCIS;

								row4HashKey.hashCodeDirty = true;

								tHash_Lookup_row4.lookup(row4HashKey);

								if (!tHash_Lookup_row4.hasNext()) { // G_TM_M_090

									rejectedInnerJoin_tMap_3 = true;

								} // G_TM_M_090

							} // G_TM_M_020

							if (tHash_Lookup_row4 != null && tHash_Lookup_row4.getCount(row4HashKey) > 1) { // G 071

								// System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row4'
								// and it contains more one result from keys : row4.codeCIS = '" +
								// row4HashKey.codeCIS + "'");
							} // G 071

							row4Struct row4 = null;

							row4Struct fromLookup_row4 = null;
							row4 = row4Default;

							if (tHash_Lookup_row4 != null && tHash_Lookup_row4.hasNext()) { // G 099

								fromLookup_row4 = tHash_Lookup_row4.next();

							} // G 099

							if (fromLookup_row4 != null) {
								row4 = fromLookup_row4;
							}

							// ###############################
							{ // start of Var scope

								// ###############################
								// # Vars tables

								Var__tMap_3__Struct Var = Var__tMap_3;
								Var.tauxRebourseement = row2.taux.isEmpty() ? "0%" : row2.taux;// ###############################
								// ###############################
								// # Output tables

								duplicated1 = null;
								reject = null;

								if (!rejectedInnerJoin_tMap_3) {

// # Output table : 'duplicated1'
									duplicated1_tmp.id = 0;
									duplicated1_tmp.codeCIS = row2.codeCIS;
									duplicated1_tmp.codeCIP7 = row2.codeCIP7;
									duplicated1_tmp.libellePresentation = row2.libelle;
									duplicated1_tmp.statutAdministratifPresentation = row2.statusAdm;
									duplicated1_tmp.etatCommercialisation = row2.etat;
									duplicated1_tmp.dateDeclarationCommercialisation = row2.date;
									duplicated1_tmp.codeCIP13 = row2.codeCIP13;
									duplicated1_tmp.agrementCollectivites = row2.agrement;
									duplicated1_tmp.tauxRemboursement = Var.tauxRebourseement;
									duplicated1_tmp.prix = row2.prix + "/" + row2.texte + "/" + row2.Column11;
									duplicated1_tmp.droitRemboursement = row2.Column12;
									duplicated1 = duplicated1_tmp;
								} // closing inner join bracket (1)
// ###### START REJECTS ##### 

// # Output reject table : 'reject'
// # Filter conditions 
								if (rejectedInnerJoin_tMap_3) {
									reject_tmp.codeCIS = row2.codeCIS;
									reject = reject_tmp;
								} // closing filter/reject
// ###############################

							} // end of Var scope

							rejectedInnerJoin_tMap_3 = false;

							tos_count_tMap_3++;

							/**
							 * [tMap_3 main ] stop
							 */

							/**
							 * [tMap_3 process_data_begin ] start
							 */

							currentComponent = "tMap_3";

							/**
							 * [tMap_3 process_data_begin ] stop
							 */
// Start of branch "duplicated1"
							if (duplicated1 != null) {

								/**
								 * [tDBOutput_3 main ] start
								 */

								currentComponent = "tDBOutput_3";

								if (execStat) {
									runStat.updateStatOnConnection(iterateId, 1, 1

											, "duplicated1"

									);
								}

								whetherReject_tDBOutput_3 = false;
								pstmt_tDBOutput_3.setInt(1, duplicated1.id);

								if (duplicated1.codeCIS == null) {
									pstmt_tDBOutput_3.setNull(2, java.sql.Types.VARCHAR);
								} else {
									pstmt_tDBOutput_3.setString(2, duplicated1.codeCIS);
								}

								if (duplicated1.codeCIP7 == null) {
									pstmt_tDBOutput_3.setNull(3, java.sql.Types.VARCHAR);
								} else {
									pstmt_tDBOutput_3.setString(3, duplicated1.codeCIP7);
								}

								if (duplicated1.libellePresentation == null) {
									pstmt_tDBOutput_3.setNull(4, java.sql.Types.VARCHAR);
								} else {
									pstmt_tDBOutput_3.setString(4, duplicated1.libellePresentation);
								}

								if (duplicated1.statutAdministratifPresentation == null) {
									pstmt_tDBOutput_3.setNull(5, java.sql.Types.VARCHAR);
								} else {
									pstmt_tDBOutput_3.setString(5, duplicated1.statutAdministratifPresentation);
								}

								if (duplicated1.etatCommercialisation == null) {
									pstmt_tDBOutput_3.setNull(6, java.sql.Types.VARCHAR);
								} else {
									pstmt_tDBOutput_3.setString(6, duplicated1.etatCommercialisation);
								}

								if (duplicated1.dateDeclarationCommercialisation == null) {
									pstmt_tDBOutput_3.setNull(7, java.sql.Types.VARCHAR);
								} else {
									pstmt_tDBOutput_3.setString(7, duplicated1.dateDeclarationCommercialisation);
								}

								if (duplicated1.codeCIP13 == null) {
									pstmt_tDBOutput_3.setNull(8, java.sql.Types.VARCHAR);
								} else {
									pstmt_tDBOutput_3.setString(8, duplicated1.codeCIP13);
								}

								if (duplicated1.agrementCollectivites == null) {
									pstmt_tDBOutput_3.setNull(9, java.sql.Types.VARCHAR);
								} else {
									pstmt_tDBOutput_3.setString(9, duplicated1.agrementCollectivites);
								}

								if (duplicated1.tauxRemboursement == null) {
									pstmt_tDBOutput_3.setNull(10, java.sql.Types.VARCHAR);
								} else {
									pstmt_tDBOutput_3.setString(10, duplicated1.tauxRemboursement);
								}

								if (duplicated1.prix == null) {
									pstmt_tDBOutput_3.setNull(11, java.sql.Types.VARCHAR);
								} else {
									pstmt_tDBOutput_3.setString(11, duplicated1.prix);
								}

								if (duplicated1.droitRemboursement == null) {
									pstmt_tDBOutput_3.setNull(12, java.sql.Types.VARCHAR);
								} else {
									pstmt_tDBOutput_3.setString(12, duplicated1.droitRemboursement);
								}

								pstmt_tDBOutput_3.addBatch();
								nb_line_tDBOutput_3++;

								batchSizeCounter_tDBOutput_3++;
								if (batchSize_tDBOutput_3 <= batchSizeCounter_tDBOutput_3) {
									try {
										int countSum_tDBOutput_3 = 0;
										for (int countEach_tDBOutput_3 : pstmt_tDBOutput_3.executeBatch()) {
											countSum_tDBOutput_3 += (countEach_tDBOutput_3 == java.sql.Statement.EXECUTE_FAILED
													? 0
													: 1);
										}
										rowsToCommitCount_tDBOutput_3 += countSum_tDBOutput_3;
										insertedCount_tDBOutput_3 += countSum_tDBOutput_3;
									} catch (java.sql.BatchUpdateException e) {
										globalMap.put("tDBOutput_3_ERROR_MESSAGE", e.getMessage());
										int countSum_tDBOutput_3 = 0;
										for (int countEach_tDBOutput_3 : e.getUpdateCounts()) {
											countSum_tDBOutput_3 += (countEach_tDBOutput_3 < 0 ? 0
													: countEach_tDBOutput_3);
										}
										rowsToCommitCount_tDBOutput_3 += countSum_tDBOutput_3;
										insertedCount_tDBOutput_3 += countSum_tDBOutput_3;
										System.err.println(e.getMessage());
									}

									batchSizeCounter_tDBOutput_3 = 0;
								}
								commitCounter_tDBOutput_3++;

								if (commitEvery_tDBOutput_3 <= commitCounter_tDBOutput_3) {

									try {
										int countSum_tDBOutput_3 = 0;
										for (int countEach_tDBOutput_3 : pstmt_tDBOutput_3.executeBatch()) {
											countSum_tDBOutput_3 += (countEach_tDBOutput_3 < 0 ? 0 : 1);
										}
										rowsToCommitCount_tDBOutput_3 += countSum_tDBOutput_3;
										insertedCount_tDBOutput_3 += countSum_tDBOutput_3;
									} catch (java.sql.BatchUpdateException e) {
										globalMap.put("tDBOutput_3_ERROR_MESSAGE", e.getMessage());
										int countSum_tDBOutput_3 = 0;
										for (int countEach_tDBOutput_3 : e.getUpdateCounts()) {
											countSum_tDBOutput_3 += (countEach_tDBOutput_3 < 0 ? 0
													: countEach_tDBOutput_3);
										}
										rowsToCommitCount_tDBOutput_3 += countSum_tDBOutput_3;
										insertedCount_tDBOutput_3 += countSum_tDBOutput_3;
										System.err.println(e.getMessage());

									}
									if (rowsToCommitCount_tDBOutput_3 != 0) {
									}
									conn_tDBOutput_3.commit();
									if (rowsToCommitCount_tDBOutput_3 != 0) {
										rowsToCommitCount_tDBOutput_3 = 0;
									}
									commitCounter_tDBOutput_3 = 0;

								}

								tos_count_tDBOutput_3++;

								/**
								 * [tDBOutput_3 main ] stop
								 */

								/**
								 * [tDBOutput_3 process_data_begin ] start
								 */

								currentComponent = "tDBOutput_3";

								/**
								 * [tDBOutput_3 process_data_begin ] stop
								 */

								/**
								 * [tDBOutput_3 process_data_end ] start
								 */

								currentComponent = "tDBOutput_3";

								/**
								 * [tDBOutput_3 process_data_end ] stop
								 */

							} // End of branch "duplicated1"

// Start of branch "reject"
							if (reject != null) {

								/**
								 * [tFileOutputDelimited_2 main ] start
								 */

								currentComponent = "tFileOutputDelimited_2";

								if (execStat) {
									runStat.updateStatOnConnection(iterateId, 1, 1

											, "reject"

									);
								}

								StringBuilder sb_tFileOutputDelimited_2 = new StringBuilder();
								if (reject.codeCIS != null) {
									sb_tFileOutputDelimited_2.append(reject.codeCIS);
								}
								sb_tFileOutputDelimited_2.append(OUT_DELIM_ROWSEP_tFileOutputDelimited_2);

								nb_line_tFileOutputDelimited_2++;
								resourceMap.put("nb_line_tFileOutputDelimited_2", nb_line_tFileOutputDelimited_2);

								outtFileOutputDelimited_2.write(sb_tFileOutputDelimited_2.toString());

								tos_count_tFileOutputDelimited_2++;

								/**
								 * [tFileOutputDelimited_2 main ] stop
								 */

								/**
								 * [tFileOutputDelimited_2 process_data_begin ] start
								 */

								currentComponent = "tFileOutputDelimited_2";

								/**
								 * [tFileOutputDelimited_2 process_data_begin ] stop
								 */

								/**
								 * [tFileOutputDelimited_2 process_data_end ] start
								 */

								currentComponent = "tFileOutputDelimited_2";

								/**
								 * [tFileOutputDelimited_2 process_data_end ] stop
								 */

							} // End of branch "reject"

							/**
							 * [tMap_3 process_data_end ] start
							 */

							currentComponent = "tMap_3";

							/**
							 * [tMap_3 process_data_end ] stop
							 */

						} // End of branch "row2"

						/**
						 * [tFileInputDelimited_3 process_data_end ] start
						 */

						currentComponent = "tFileInputDelimited_3";

						/**
						 * [tFileInputDelimited_3 process_data_end ] stop
						 */

						/**
						 * [tFileInputDelimited_3 end ] start
						 */

						currentComponent = "tFileInputDelimited_3";

					}
				} finally {
					if (!((Object) ("C:/Users/Ethan/Documents/workspace/GROMED/data/fichiers/CIS_CIP_bdpm.txt") instanceof java.io.InputStream)) {
						if (fid_tFileInputDelimited_3 != null) {
							fid_tFileInputDelimited_3.close();
						}
					}
					if (fid_tFileInputDelimited_3 != null) {
						globalMap.put("tFileInputDelimited_3_NB_LINE", fid_tFileInputDelimited_3.getRowNumber());

					}
				}

				ok_Hash.put("tFileInputDelimited_3", true);
				end_Hash.put("tFileInputDelimited_3", System.currentTimeMillis());

				/**
				 * [tFileInputDelimited_3 end ] stop
				 */

				/**
				 * [tMap_3 end ] start
				 */

				currentComponent = "tMap_3";

// ###############################
// # Lookup hashes releasing
				if (tHash_Lookup_row4 != null) {
					tHash_Lookup_row4.endGet();
				}
				globalMap.remove("tHash_Lookup_row4");

// ###############################      

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row2");
				}

				ok_Hash.put("tMap_3", true);
				end_Hash.put("tMap_3", System.currentTimeMillis());

				/**
				 * [tMap_3 end ] stop
				 */

				/**
				 * [tDBOutput_3 end ] start
				 */

				currentComponent = "tDBOutput_3";

				try {
					if (batchSizeCounter_tDBOutput_3 != 0) {
						int countSum_tDBOutput_3 = 0;

						for (int countEach_tDBOutput_3 : pstmt_tDBOutput_3.executeBatch()) {
							countSum_tDBOutput_3 += (countEach_tDBOutput_3 == java.sql.Statement.EXECUTE_FAILED ? 0
									: 1);
						}
						rowsToCommitCount_tDBOutput_3 += countSum_tDBOutput_3;

						insertedCount_tDBOutput_3 += countSum_tDBOutput_3;

					}

				} catch (java.sql.BatchUpdateException e) {
					globalMap.put(currentComponent + "_ERROR_MESSAGE", e.getMessage());

					int countSum_tDBOutput_3 = 0;
					for (int countEach_tDBOutput_3 : e.getUpdateCounts()) {
						countSum_tDBOutput_3 += (countEach_tDBOutput_3 < 0 ? 0 : countEach_tDBOutput_3);
					}
					rowsToCommitCount_tDBOutput_3 += countSum_tDBOutput_3;

					insertedCount_tDBOutput_3 += countSum_tDBOutput_3;

					System.err.println(e.getMessage());

				}
				batchSizeCounter_tDBOutput_3 = 0;

				if (pstmt_tDBOutput_3 != null) {

					pstmt_tDBOutput_3.close();
					resourceMap.remove("pstmt_tDBOutput_3");

				}
				resourceMap.put("statementClosed_tDBOutput_3", true);
				if (commitCounter_tDBOutput_3 > 0 && rowsToCommitCount_tDBOutput_3 != 0) {

				}
				conn_tDBOutput_3.commit();
				if (commitCounter_tDBOutput_3 > 0 && rowsToCommitCount_tDBOutput_3 != 0) {

					rowsToCommitCount_tDBOutput_3 = 0;
				}
				commitCounter_tDBOutput_3 = 0;

				conn_tDBOutput_3.close();

				resourceMap.put("finish_tDBOutput_3", true);

				nb_line_deleted_tDBOutput_3 = nb_line_deleted_tDBOutput_3 + deletedCount_tDBOutput_3;
				nb_line_update_tDBOutput_3 = nb_line_update_tDBOutput_3 + updatedCount_tDBOutput_3;
				nb_line_inserted_tDBOutput_3 = nb_line_inserted_tDBOutput_3 + insertedCount_tDBOutput_3;
				nb_line_rejected_tDBOutput_3 = nb_line_rejected_tDBOutput_3 + rejectedCount_tDBOutput_3;

				globalMap.put("tDBOutput_3_NB_LINE", nb_line_tDBOutput_3);
				globalMap.put("tDBOutput_3_NB_LINE_UPDATED", nb_line_update_tDBOutput_3);
				globalMap.put("tDBOutput_3_NB_LINE_INSERTED", nb_line_inserted_tDBOutput_3);
				globalMap.put("tDBOutput_3_NB_LINE_DELETED", nb_line_deleted_tDBOutput_3);
				globalMap.put("tDBOutput_3_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_3);

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "duplicated1");
				}

				ok_Hash.put("tDBOutput_3", true);
				end_Hash.put("tDBOutput_3", System.currentTimeMillis());

				/**
				 * [tDBOutput_3 end ] stop
				 */

				/**
				 * [tFileOutputDelimited_2 end ] start
				 */

				currentComponent = "tFileOutputDelimited_2";

				if (outtFileOutputDelimited_2 != null) {
					outtFileOutputDelimited_2.flush();
					outtFileOutputDelimited_2.close();
				}

				globalMap.put("tFileOutputDelimited_2_NB_LINE", nb_line_tFileOutputDelimited_2);
				globalMap.put("tFileOutputDelimited_2_FILE_NAME", fileName_tFileOutputDelimited_2);

				resourceMap.put("finish_tFileOutputDelimited_2", true);

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "reject");
				}

				ok_Hash.put("tFileOutputDelimited_2", true);
				end_Hash.put("tFileOutputDelimited_2", System.currentTimeMillis());

				/**
				 * [tFileOutputDelimited_2 end ] stop
				 */

			} // end the resume

			if (resumeEntryMethodName == null || globalResumeTicket) {
				resumeUtil.addLog("CHECKPOINT", "CONNECTION:SUBJOB_OK:tFileInputDelimited_3:OnSubjobOk", "",
						Thread.currentThread().getId() + "", "", "", "", "", "");
			}

			if (execStat) {
				runStat.updateStatOnConnection("OnSubjobOk3", 0, "ok");
			}

			tFileInputDelimited_4Process(globalMap);

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			// free memory for "tMap_3"
			globalMap.remove("tHash_Lookup_row4");

			try {

				/**
				 * [tFileInputDelimited_3 finally ] start
				 */

				currentComponent = "tFileInputDelimited_3";

				/**
				 * [tFileInputDelimited_3 finally ] stop
				 */

				/**
				 * [tMap_3 finally ] start
				 */

				currentComponent = "tMap_3";

				/**
				 * [tMap_3 finally ] stop
				 */

				/**
				 * [tDBOutput_3 finally ] start
				 */

				currentComponent = "tDBOutput_3";

				try {
					if (resourceMap.get("statementClosed_tDBOutput_3") == null) {
						java.sql.PreparedStatement pstmtToClose_tDBOutput_3 = null;
						if ((pstmtToClose_tDBOutput_3 = (java.sql.PreparedStatement) resourceMap
								.remove("pstmt_tDBOutput_3")) != null) {
							pstmtToClose_tDBOutput_3.close();
						}
					}
				} finally {
					if (resourceMap.get("finish_tDBOutput_3") == null) {
						java.sql.Connection ctn_tDBOutput_3 = null;
						if ((ctn_tDBOutput_3 = (java.sql.Connection) resourceMap.get("conn_tDBOutput_3")) != null) {
							try {
								ctn_tDBOutput_3.close();
							} catch (java.sql.SQLException sqlEx_tDBOutput_3) {
								String errorMessage_tDBOutput_3 = "failed to close the connection in tDBOutput_3 :"
										+ sqlEx_tDBOutput_3.getMessage();
								System.err.println(errorMessage_tDBOutput_3);
							}
						}
					}
				}

				/**
				 * [tDBOutput_3 finally ] stop
				 */

				/**
				 * [tFileOutputDelimited_2 finally ] start
				 */

				currentComponent = "tFileOutputDelimited_2";

				if (resourceMap.get("finish_tFileOutputDelimited_2") == null) {

					java.io.Writer outtFileOutputDelimited_2 = (java.io.Writer) resourceMap
							.get("out_tFileOutputDelimited_2");
					if (outtFileOutputDelimited_2 != null) {
						outtFileOutputDelimited_2.flush();
						outtFileOutputDelimited_2.close();
					}

				}

				/**
				 * [tFileOutputDelimited_2 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tFileInputDelimited_3_SUBPROCESS_STATE", 1);
	}

	public static class copyOfduplicatedStruct implements routines.system.IPersistableRow<copyOfduplicatedStruct> {
		final static byte[] commonByteArrayLock_GROMED_dump_gros_med_brut = new byte[0];
		static byte[] commonByteArray_GROMED_dump_gros_med_brut = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public int id;

		public int getId() {
			return this.id;
		}

		public String codeCIS;

		public String getCodeCIS() {
			return this.codeCIS;
		}

		public String designationPharmaceutique;

		public String getDesignationPharmaceutique() {
			return this.designationPharmaceutique;
		}

		public String codeSubstance;

		public String getCodeSubstance() {
			return this.codeSubstance;
		}

		public String denominationSubstance;

		public String getDenominationSubstance() {
			return this.denominationSubstance;
		}

		public String dosageSubstance;

		public String getDosageSubstance() {
			return this.dosageSubstance;
		}

		public String refDosage;

		public String getRefDosage() {
			return this.refDosage;
		}

		public String estActif;

		public String getEstActif() {
			return this.estActif;
		}

		public String numCompo;

		public String getNumCompo() {
			return this.numCompo;
		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + (int) this.id;

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final copyOfduplicatedStruct other = (copyOfduplicatedStruct) obj;

			if (this.id != other.id)
				return false;

			return true;
		}

		public void copyDataTo(copyOfduplicatedStruct other) {

			other.id = this.id;
			other.codeCIS = this.codeCIS;
			other.designationPharmaceutique = this.designationPharmaceutique;
			other.codeSubstance = this.codeSubstance;
			other.denominationSubstance = this.denominationSubstance;
			other.dosageSubstance = this.dosageSubstance;
			other.refDosage = this.refDosage;
			other.estActif = this.estActif;
			other.numCompo = this.numCompo;

		}

		public void copyKeysDataTo(copyOfduplicatedStruct other) {

			other.id = this.id;

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_GROMED_dump_gros_med_brut.length) {
					if (length < 1024 && commonByteArray_GROMED_dump_gros_med_brut.length == 0) {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[1024];
					} else {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_GROMED_dump_gros_med_brut, 0, length);
				strReturn = new String(commonByteArray_GROMED_dump_gros_med_brut, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_GROMED_dump_gros_med_brut.length) {
					if (length < 1024 && commonByteArray_GROMED_dump_gros_med_brut.length == 0) {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[1024];
					} else {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_GROMED_dump_gros_med_brut, 0, length);
				strReturn = new String(commonByteArray_GROMED_dump_gros_med_brut, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_GROMED_dump_gros_med_brut) {

				try {

					int length = 0;

					this.id = dis.readInt();

					this.codeCIS = readString(dis);

					this.designationPharmaceutique = readString(dis);

					this.codeSubstance = readString(dis);

					this.denominationSubstance = readString(dis);

					this.dosageSubstance = readString(dis);

					this.refDosage = readString(dis);

					this.estActif = readString(dis);

					this.numCompo = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_GROMED_dump_gros_med_brut) {

				try {

					int length = 0;

					this.id = dis.readInt();

					this.codeCIS = readString(dis);

					this.designationPharmaceutique = readString(dis);

					this.codeSubstance = readString(dis);

					this.denominationSubstance = readString(dis);

					this.dosageSubstance = readString(dis);

					this.refDosage = readString(dis);

					this.estActif = readString(dis);

					this.numCompo = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// int

				dos.writeInt(this.id);

				// String

				writeString(this.codeCIS, dos);

				// String

				writeString(this.designationPharmaceutique, dos);

				// String

				writeString(this.codeSubstance, dos);

				// String

				writeString(this.denominationSubstance, dos);

				// String

				writeString(this.dosageSubstance, dos);

				// String

				writeString(this.refDosage, dos);

				// String

				writeString(this.estActif, dos);

				// String

				writeString(this.numCompo, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// int

				dos.writeInt(this.id);

				// String

				writeString(this.codeCIS, dos);

				// String

				writeString(this.designationPharmaceutique, dos);

				// String

				writeString(this.codeSubstance, dos);

				// String

				writeString(this.denominationSubstance, dos);

				// String

				writeString(this.dosageSubstance, dos);

				// String

				writeString(this.refDosage, dos);

				// String

				writeString(this.estActif, dos);

				// String

				writeString(this.numCompo, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("id=" + String.valueOf(id));
			sb.append(",codeCIS=" + codeCIS);
			sb.append(",designationPharmaceutique=" + designationPharmaceutique);
			sb.append(",codeSubstance=" + codeSubstance);
			sb.append(",denominationSubstance=" + denominationSubstance);
			sb.append(",dosageSubstance=" + dosageSubstance);
			sb.append(",refDosage=" + refDosage);
			sb.append(",estActif=" + estActif);
			sb.append(",numCompo=" + numCompo);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(copyOfduplicatedStruct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.id, other.id);
			if (returnValue != 0) {
				return returnValue;
			}

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class primaryFailStruct implements routines.system.IPersistableRow<primaryFailStruct> {
		final static byte[] commonByteArrayLock_GROMED_dump_gros_med_brut = new byte[0];
		static byte[] commonByteArray_GROMED_dump_gros_med_brut = new byte[0];

		public String codeCIS;

		public String getCodeCIS() {
			return this.codeCIS;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_GROMED_dump_gros_med_brut.length) {
					if (length < 1024 && commonByteArray_GROMED_dump_gros_med_brut.length == 0) {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[1024];
					} else {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_GROMED_dump_gros_med_brut, 0, length);
				strReturn = new String(commonByteArray_GROMED_dump_gros_med_brut, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_GROMED_dump_gros_med_brut.length) {
					if (length < 1024 && commonByteArray_GROMED_dump_gros_med_brut.length == 0) {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[1024];
					} else {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_GROMED_dump_gros_med_brut, 0, length);
				strReturn = new String(commonByteArray_GROMED_dump_gros_med_brut, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_GROMED_dump_gros_med_brut) {

				try {

					int length = 0;

					this.codeCIS = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_GROMED_dump_gros_med_brut) {

				try {

					int length = 0;

					this.codeCIS = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.codeCIS, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.codeCIS, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("codeCIS=" + codeCIS);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(primaryFailStruct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class row6Struct implements routines.system.IPersistableRow<row6Struct> {
		final static byte[] commonByteArrayLock_GROMED_dump_gros_med_brut = new byte[0];
		static byte[] commonByteArray_GROMED_dump_gros_med_brut = new byte[0];

		public String codeCIS;

		public String getCodeCIS() {
			return this.codeCIS;
		}

		public String designation;

		public String getDesignation() {
			return this.designation;
		}

		public String codeSubtance;

		public String getCodeSubtance() {
			return this.codeSubtance;
		}

		public String denomination;

		public String getDenomination() {
			return this.denomination;
		}

		public String dosage;

		public String getDosage() {
			return this.dosage;
		}

		public String ref;

		public String getRef() {
			return this.ref;
		}

		public String nature;

		public String getNature() {
			return this.nature;
		}

		public String num;

		public String getNum() {
			return this.num;
		}

		public String Column8;

		public String getColumn8() {
			return this.Column8;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_GROMED_dump_gros_med_brut.length) {
					if (length < 1024 && commonByteArray_GROMED_dump_gros_med_brut.length == 0) {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[1024];
					} else {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_GROMED_dump_gros_med_brut, 0, length);
				strReturn = new String(commonByteArray_GROMED_dump_gros_med_brut, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_GROMED_dump_gros_med_brut.length) {
					if (length < 1024 && commonByteArray_GROMED_dump_gros_med_brut.length == 0) {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[1024];
					} else {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_GROMED_dump_gros_med_brut, 0, length);
				strReturn = new String(commonByteArray_GROMED_dump_gros_med_brut, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_GROMED_dump_gros_med_brut) {

				try {

					int length = 0;

					this.codeCIS = readString(dis);

					this.designation = readString(dis);

					this.codeSubtance = readString(dis);

					this.denomination = readString(dis);

					this.dosage = readString(dis);

					this.ref = readString(dis);

					this.nature = readString(dis);

					this.num = readString(dis);

					this.Column8 = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_GROMED_dump_gros_med_brut) {

				try {

					int length = 0;

					this.codeCIS = readString(dis);

					this.designation = readString(dis);

					this.codeSubtance = readString(dis);

					this.denomination = readString(dis);

					this.dosage = readString(dis);

					this.ref = readString(dis);

					this.nature = readString(dis);

					this.num = readString(dis);

					this.Column8 = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.codeCIS, dos);

				// String

				writeString(this.designation, dos);

				// String

				writeString(this.codeSubtance, dos);

				// String

				writeString(this.denomination, dos);

				// String

				writeString(this.dosage, dos);

				// String

				writeString(this.ref, dos);

				// String

				writeString(this.nature, dos);

				// String

				writeString(this.num, dos);

				// String

				writeString(this.Column8, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.codeCIS, dos);

				// String

				writeString(this.designation, dos);

				// String

				writeString(this.codeSubtance, dos);

				// String

				writeString(this.denomination, dos);

				// String

				writeString(this.dosage, dos);

				// String

				writeString(this.ref, dos);

				// String

				writeString(this.nature, dos);

				// String

				writeString(this.num, dos);

				// String

				writeString(this.Column8, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("codeCIS=" + codeCIS);
			sb.append(",designation=" + designation);
			sb.append(",codeSubtance=" + codeSubtance);
			sb.append(",denomination=" + denomination);
			sb.append(",dosage=" + dosage);
			sb.append(",ref=" + ref);
			sb.append(",nature=" + nature);
			sb.append(",num=" + num);
			sb.append(",Column8=" + Column8);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row6Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class after_tFileInputDelimited_4Struct
			implements routines.system.IPersistableRow<after_tFileInputDelimited_4Struct> {
		final static byte[] commonByteArrayLock_GROMED_dump_gros_med_brut = new byte[0];
		static byte[] commonByteArray_GROMED_dump_gros_med_brut = new byte[0];

		public String codeCIS;

		public String getCodeCIS() {
			return this.codeCIS;
		}

		public String designation;

		public String getDesignation() {
			return this.designation;
		}

		public String codeSubtance;

		public String getCodeSubtance() {
			return this.codeSubtance;
		}

		public String denomination;

		public String getDenomination() {
			return this.denomination;
		}

		public String dosage;

		public String getDosage() {
			return this.dosage;
		}

		public String ref;

		public String getRef() {
			return this.ref;
		}

		public String nature;

		public String getNature() {
			return this.nature;
		}

		public String num;

		public String getNum() {
			return this.num;
		}

		public String Column8;

		public String getColumn8() {
			return this.Column8;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_GROMED_dump_gros_med_brut.length) {
					if (length < 1024 && commonByteArray_GROMED_dump_gros_med_brut.length == 0) {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[1024];
					} else {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_GROMED_dump_gros_med_brut, 0, length);
				strReturn = new String(commonByteArray_GROMED_dump_gros_med_brut, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_GROMED_dump_gros_med_brut.length) {
					if (length < 1024 && commonByteArray_GROMED_dump_gros_med_brut.length == 0) {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[1024];
					} else {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_GROMED_dump_gros_med_brut, 0, length);
				strReturn = new String(commonByteArray_GROMED_dump_gros_med_brut, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_GROMED_dump_gros_med_brut) {

				try {

					int length = 0;

					this.codeCIS = readString(dis);

					this.designation = readString(dis);

					this.codeSubtance = readString(dis);

					this.denomination = readString(dis);

					this.dosage = readString(dis);

					this.ref = readString(dis);

					this.nature = readString(dis);

					this.num = readString(dis);

					this.Column8 = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_GROMED_dump_gros_med_brut) {

				try {

					int length = 0;

					this.codeCIS = readString(dis);

					this.designation = readString(dis);

					this.codeSubtance = readString(dis);

					this.denomination = readString(dis);

					this.dosage = readString(dis);

					this.ref = readString(dis);

					this.nature = readString(dis);

					this.num = readString(dis);

					this.Column8 = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.codeCIS, dos);

				// String

				writeString(this.designation, dos);

				// String

				writeString(this.codeSubtance, dos);

				// String

				writeString(this.denomination, dos);

				// String

				writeString(this.dosage, dos);

				// String

				writeString(this.ref, dos);

				// String

				writeString(this.nature, dos);

				// String

				writeString(this.num, dos);

				// String

				writeString(this.Column8, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.codeCIS, dos);

				// String

				writeString(this.designation, dos);

				// String

				writeString(this.codeSubtance, dos);

				// String

				writeString(this.denomination, dos);

				// String

				writeString(this.dosage, dos);

				// String

				writeString(this.ref, dos);

				// String

				writeString(this.nature, dos);

				// String

				writeString(this.num, dos);

				// String

				writeString(this.Column8, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("codeCIS=" + codeCIS);
			sb.append(",designation=" + designation);
			sb.append(",codeSubtance=" + codeSubtance);
			sb.append(",denomination=" + denomination);
			sb.append(",dosage=" + dosage);
			sb.append(",ref=" + ref);
			sb.append(",nature=" + nature);
			sb.append(",num=" + num);
			sb.append(",Column8=" + Column8);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(after_tFileInputDelimited_4Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public void tFileInputDelimited_4Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tFileInputDelimited_4_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				tDBInput_3Process(globalMap);

				row6Struct row6 = new row6Struct();
				copyOfduplicatedStruct copyOfduplicated = new copyOfduplicatedStruct();
				primaryFailStruct primaryFail = new primaryFailStruct();

				/**
				 * [tDBOutput_4 begin ] start
				 */

				ok_Hash.put("tDBOutput_4", false);
				start_Hash.put("tDBOutput_4", System.currentTimeMillis());

				currentComponent = "tDBOutput_4";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "copyOfduplicated");
				}

				int tos_count_tDBOutput_4 = 0;

				int nb_line_tDBOutput_4 = 0;
				int nb_line_update_tDBOutput_4 = 0;
				int nb_line_inserted_tDBOutput_4 = 0;
				int nb_line_deleted_tDBOutput_4 = 0;
				int nb_line_rejected_tDBOutput_4 = 0;

				int deletedCount_tDBOutput_4 = 0;
				int updatedCount_tDBOutput_4 = 0;
				int insertedCount_tDBOutput_4 = 0;
				int rowsToCommitCount_tDBOutput_4 = 0;
				int rejectedCount_tDBOutput_4 = 0;

				String tableName_tDBOutput_4 = "cis_compo_bdpm";
				boolean whetherReject_tDBOutput_4 = false;

				java.util.Calendar calendar_tDBOutput_4 = java.util.Calendar.getInstance();
				calendar_tDBOutput_4.set(1, 0, 1, 0, 0, 0);
				long year1_tDBOutput_4 = calendar_tDBOutput_4.getTime().getTime();
				calendar_tDBOutput_4.set(10000, 0, 1, 0, 0, 0);
				long year10000_tDBOutput_4 = calendar_tDBOutput_4.getTime().getTime();
				long date_tDBOutput_4;

				java.sql.Connection conn_tDBOutput_4 = null;

				String properties_tDBOutput_4 = context.gros_med_brut1_AdditionalParams;
				if (properties_tDBOutput_4 == null || properties_tDBOutput_4.trim().length() == 0) {
					properties_tDBOutput_4 = "rewriteBatchedStatements=true&allowLoadLocalInfile=true";
				} else {
					if (!properties_tDBOutput_4.contains("rewriteBatchedStatements=")) {
						properties_tDBOutput_4 += "&rewriteBatchedStatements=true";
					}

					if (!properties_tDBOutput_4.contains("allowLoadLocalInfile=")) {
						properties_tDBOutput_4 += "&allowLoadLocalInfile=true";
					}
				}

				String url_tDBOutput_4 = "jdbc:mariadb://" + context.gros_med_brut1_Server + ":"
						+ context.gros_med_brut1_Port + "/" + context.gros_med_brut1_Database + "?"
						+ properties_tDBOutput_4;

				String driverClass_tDBOutput_4 = "org.mariadb.jdbc.Driver";

				String dbUser_tDBOutput_4 = context.gros_med_brut1_Login;

				final String decryptedPassword_tDBOutput_4 = context.gros_med_brut1_Password;

				String dbPwd_tDBOutput_4 = decryptedPassword_tDBOutput_4;
				java.lang.Class.forName(driverClass_tDBOutput_4);

				conn_tDBOutput_4 = java.sql.DriverManager.getConnection(url_tDBOutput_4, dbUser_tDBOutput_4,
						dbPwd_tDBOutput_4);

				resourceMap.put("conn_tDBOutput_4", conn_tDBOutput_4);
				conn_tDBOutput_4.setAutoCommit(false);
				int commitEvery_tDBOutput_4 = 10000;
				int commitCounter_tDBOutput_4 = 0;

				int count_tDBOutput_4 = 0;

				try (java.sql.Statement stmtClear_tDBOutput_4 = conn_tDBOutput_4.createStatement()) {
					stmtClear_tDBOutput_4.executeUpdate("DELETE FROM `" + tableName_tDBOutput_4 + "`");
				}

				String insert_tDBOutput_4 = "INSERT INTO `" + "cis_compo_bdpm"
						+ "` (`id`,`codeCIS`,`designationPharmaceutique`,`codeSubstance`,`denominationSubstance`,`dosageSubstance`,`refDosage`,`estActif`,`numCompo`) VALUES (?,?,?,?,?,?,?,?,?)";
				int batchSize_tDBOutput_4 = 100;
				int batchSizeCounter_tDBOutput_4 = 0;

				java.sql.PreparedStatement pstmt_tDBOutput_4 = conn_tDBOutput_4.prepareStatement(insert_tDBOutput_4);
				resourceMap.put("pstmt_tDBOutput_4", pstmt_tDBOutput_4);

				/**
				 * [tDBOutput_4 begin ] stop
				 */

				/**
				 * [tFileOutputDelimited_3 begin ] start
				 */

				ok_Hash.put("tFileOutputDelimited_3", false);
				start_Hash.put("tFileOutputDelimited_3", System.currentTimeMillis());

				currentComponent = "tFileOutputDelimited_3";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "primaryFail");
				}

				int tos_count_tFileOutputDelimited_3 = 0;

				String fileName_tFileOutputDelimited_3 = "";
				fileName_tFileOutputDelimited_3 = (new java.io.File(
						context.source + "log/cis_compo_bdpm_Unknow_Primarykey.log")).getAbsolutePath().replace("\\",
								"/");
				String fullName_tFileOutputDelimited_3 = null;
				String extension_tFileOutputDelimited_3 = null;
				String directory_tFileOutputDelimited_3 = null;
				if ((fileName_tFileOutputDelimited_3.indexOf("/") != -1)) {
					if (fileName_tFileOutputDelimited_3.lastIndexOf(".") < fileName_tFileOutputDelimited_3
							.lastIndexOf("/")) {
						fullName_tFileOutputDelimited_3 = fileName_tFileOutputDelimited_3;
						extension_tFileOutputDelimited_3 = "";
					} else {
						fullName_tFileOutputDelimited_3 = fileName_tFileOutputDelimited_3.substring(0,
								fileName_tFileOutputDelimited_3.lastIndexOf("."));
						extension_tFileOutputDelimited_3 = fileName_tFileOutputDelimited_3
								.substring(fileName_tFileOutputDelimited_3.lastIndexOf("."));
					}
					directory_tFileOutputDelimited_3 = fileName_tFileOutputDelimited_3.substring(0,
							fileName_tFileOutputDelimited_3.lastIndexOf("/"));
				} else {
					if (fileName_tFileOutputDelimited_3.lastIndexOf(".") != -1) {
						fullName_tFileOutputDelimited_3 = fileName_tFileOutputDelimited_3.substring(0,
								fileName_tFileOutputDelimited_3.lastIndexOf("."));
						extension_tFileOutputDelimited_3 = fileName_tFileOutputDelimited_3
								.substring(fileName_tFileOutputDelimited_3.lastIndexOf("."));
					} else {
						fullName_tFileOutputDelimited_3 = fileName_tFileOutputDelimited_3;
						extension_tFileOutputDelimited_3 = "";
					}
					directory_tFileOutputDelimited_3 = "";
				}
				boolean isFileGenerated_tFileOutputDelimited_3 = true;
				java.io.File filetFileOutputDelimited_3 = new java.io.File(fileName_tFileOutputDelimited_3);
				globalMap.put("tFileOutputDelimited_3_FILE_NAME", fileName_tFileOutputDelimited_3);
				int nb_line_tFileOutputDelimited_3 = 0;
				int splitedFileNo_tFileOutputDelimited_3 = 0;
				int currentRow_tFileOutputDelimited_3 = 0;

				final String OUT_DELIM_tFileOutputDelimited_3 = /** Start field tFileOutputDelimited_3:FIELDSEPARATOR */
						";"/** End field tFileOutputDelimited_3:FIELDSEPARATOR */
				;

				final String OUT_DELIM_ROWSEP_tFileOutputDelimited_3 = /**
																		 * Start field
																		 * tFileOutputDelimited_3:ROWSEPARATOR
																		 */
						"\n"/** End field tFileOutputDelimited_3:ROWSEPARATOR */
				;

				// create directory only if not exists
				if (directory_tFileOutputDelimited_3 != null && directory_tFileOutputDelimited_3.trim().length() != 0) {
					java.io.File dir_tFileOutputDelimited_3 = new java.io.File(directory_tFileOutputDelimited_3);
					if (!dir_tFileOutputDelimited_3.exists()) {
						dir_tFileOutputDelimited_3.mkdirs();
					}
				}

				// routines.system.Row
				java.io.Writer outtFileOutputDelimited_3 = null;

				java.io.File fileToDelete_tFileOutputDelimited_3 = new java.io.File(fileName_tFileOutputDelimited_3);
				if (fileToDelete_tFileOutputDelimited_3.exists()) {
					fileToDelete_tFileOutputDelimited_3.delete();
				}
				outtFileOutputDelimited_3 = new java.io.BufferedWriter(new java.io.OutputStreamWriter(
						new java.io.FileOutputStream(fileName_tFileOutputDelimited_3, false), "ISO-8859-15"));

				resourceMap.put("out_tFileOutputDelimited_3", outtFileOutputDelimited_3);
				resourceMap.put("nb_line_tFileOutputDelimited_3", nb_line_tFileOutputDelimited_3);

				/**
				 * [tFileOutputDelimited_3 begin ] stop
				 */

				/**
				 * [tMap_4 begin ] start
				 */

				ok_Hash.put("tMap_4", false);
				start_Hash.put("tMap_4", System.currentTimeMillis());

				currentComponent = "tMap_4";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row6");
				}

				int tos_count_tMap_4 = 0;

// ###############################
// # Lookup's keys initialization

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row7Struct> tHash_Lookup_row7 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row7Struct>) ((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row7Struct>) globalMap
						.get("tHash_Lookup_row7"));

				row7Struct row7HashKey = new row7Struct();
				row7Struct row7Default = new row7Struct();
// ###############################        

// ###############################
// # Vars initialization
				class Var__tMap_4__Struct {
				}
				Var__tMap_4__Struct Var__tMap_4 = new Var__tMap_4__Struct();
// ###############################

// ###############################
// # Outputs initialization
				copyOfduplicatedStruct copyOfduplicated_tmp = new copyOfduplicatedStruct();
				primaryFailStruct primaryFail_tmp = new primaryFailStruct();
// ###############################

				/**
				 * [tMap_4 begin ] stop
				 */

				/**
				 * [tFileInputDelimited_4 begin ] start
				 */

				ok_Hash.put("tFileInputDelimited_4", false);
				start_Hash.put("tFileInputDelimited_4", System.currentTimeMillis());

				currentComponent = "tFileInputDelimited_4";

				int tos_count_tFileInputDelimited_4 = 0;

				final routines.system.RowState rowstate_tFileInputDelimited_4 = new routines.system.RowState();

				int nb_line_tFileInputDelimited_4 = 0;
				org.talend.fileprocess.FileInputDelimited fid_tFileInputDelimited_4 = null;
				int limit_tFileInputDelimited_4 = -1;
				try {

					Object filename_tFileInputDelimited_4 = "C:/Users/Ethan/Documents/workspace/GROMED/data/fichiers/CIS_COMPO_bdpm.txt";
					if (filename_tFileInputDelimited_4 instanceof java.io.InputStream) {

						int footer_value_tFileInputDelimited_4 = 0, random_value_tFileInputDelimited_4 = -1;
						if (footer_value_tFileInputDelimited_4 > 0 || random_value_tFileInputDelimited_4 > 0) {
							throw new java.lang.Exception(
									"When the input source is a stream,footer and random shouldn't be bigger than 0.");
						}

					}
					try {
						fid_tFileInputDelimited_4 = new org.talend.fileprocess.FileInputDelimited(
								"C:/Users/Ethan/Documents/workspace/GROMED/data/fichiers/CIS_COMPO_bdpm.txt",
								"windows-1252", "\t", "\n", false, 0, 0, limit_tFileInputDelimited_4, -1, false);
					} catch (java.lang.Exception e) {
						globalMap.put("tFileInputDelimited_4_ERROR_MESSAGE", e.getMessage());

						System.err.println(e.getMessage());

					}

					while (fid_tFileInputDelimited_4 != null && fid_tFileInputDelimited_4.nextRecord()) {
						rowstate_tFileInputDelimited_4.reset();

						row6 = null;

						boolean whetherReject_tFileInputDelimited_4 = false;
						row6 = new row6Struct();
						try {

							int columnIndexWithD_tFileInputDelimited_4 = 0;

							columnIndexWithD_tFileInputDelimited_4 = 0;

							row6.codeCIS = fid_tFileInputDelimited_4.get(columnIndexWithD_tFileInputDelimited_4);

							columnIndexWithD_tFileInputDelimited_4 = 1;

							row6.designation = fid_tFileInputDelimited_4.get(columnIndexWithD_tFileInputDelimited_4);

							columnIndexWithD_tFileInputDelimited_4 = 2;

							row6.codeSubtance = fid_tFileInputDelimited_4.get(columnIndexWithD_tFileInputDelimited_4);

							columnIndexWithD_tFileInputDelimited_4 = 3;

							row6.denomination = fid_tFileInputDelimited_4.get(columnIndexWithD_tFileInputDelimited_4);

							columnIndexWithD_tFileInputDelimited_4 = 4;

							row6.dosage = fid_tFileInputDelimited_4.get(columnIndexWithD_tFileInputDelimited_4);

							columnIndexWithD_tFileInputDelimited_4 = 5;

							row6.ref = fid_tFileInputDelimited_4.get(columnIndexWithD_tFileInputDelimited_4);

							columnIndexWithD_tFileInputDelimited_4 = 6;

							row6.nature = fid_tFileInputDelimited_4.get(columnIndexWithD_tFileInputDelimited_4);

							columnIndexWithD_tFileInputDelimited_4 = 7;

							row6.num = fid_tFileInputDelimited_4.get(columnIndexWithD_tFileInputDelimited_4);

							columnIndexWithD_tFileInputDelimited_4 = 8;

							row6.Column8 = fid_tFileInputDelimited_4.get(columnIndexWithD_tFileInputDelimited_4);

							if (rowstate_tFileInputDelimited_4.getException() != null) {
								throw rowstate_tFileInputDelimited_4.getException();
							}

						} catch (java.lang.Exception e) {
							globalMap.put("tFileInputDelimited_4_ERROR_MESSAGE", e.getMessage());
							whetherReject_tFileInputDelimited_4 = true;

							System.err.println(e.getMessage());
							row6 = null;

						}

						/**
						 * [tFileInputDelimited_4 begin ] stop
						 */

						/**
						 * [tFileInputDelimited_4 main ] start
						 */

						currentComponent = "tFileInputDelimited_4";

						tos_count_tFileInputDelimited_4++;

						/**
						 * [tFileInputDelimited_4 main ] stop
						 */

						/**
						 * [tFileInputDelimited_4 process_data_begin ] start
						 */

						currentComponent = "tFileInputDelimited_4";

						/**
						 * [tFileInputDelimited_4 process_data_begin ] stop
						 */
// Start of branch "row6"
						if (row6 != null) {

							/**
							 * [tMap_4 main ] start
							 */

							currentComponent = "tMap_4";

							if (execStat) {
								runStat.updateStatOnConnection(iterateId, 1, 1

										, "row6"

								);
							}

							boolean hasCasePrimitiveKeyWithNull_tMap_4 = false;

							// ###############################
							// # Input tables (lookups)
							boolean rejectedInnerJoin_tMap_4 = false;
							boolean mainRowRejected_tMap_4 = false;

							///////////////////////////////////////////////
							// Starting Lookup Table "row7"
							///////////////////////////////////////////////

							boolean forceLooprow7 = false;

							row7Struct row7ObjectFromLookup = null;

							if (!rejectedInnerJoin_tMap_4) { // G_TM_M_020

								hasCasePrimitiveKeyWithNull_tMap_4 = false;

								row7HashKey.codeCIS = row6.codeCIS;

								row7HashKey.hashCodeDirty = true;

								tHash_Lookup_row7.lookup(row7HashKey);

								if (!tHash_Lookup_row7.hasNext()) { // G_TM_M_090

									rejectedInnerJoin_tMap_4 = true;

								} // G_TM_M_090

							} // G_TM_M_020

							if (tHash_Lookup_row7 != null && tHash_Lookup_row7.getCount(row7HashKey) > 1) { // G 071

								// System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row7'
								// and it contains more one result from keys : row7.codeCIS = '" +
								// row7HashKey.codeCIS + "'");
							} // G 071

							row7Struct row7 = null;

							row7Struct fromLookup_row7 = null;
							row7 = row7Default;

							if (tHash_Lookup_row7 != null && tHash_Lookup_row7.hasNext()) { // G 099

								fromLookup_row7 = tHash_Lookup_row7.next();

							} // G 099

							if (fromLookup_row7 != null) {
								row7 = fromLookup_row7;
							}

							// ###############################
							{ // start of Var scope

								// ###############################
								// # Vars tables

								Var__tMap_4__Struct Var = Var__tMap_4;// ###############################
								// ###############################
								// # Output tables

								copyOfduplicated = null;
								primaryFail = null;

								if (!rejectedInnerJoin_tMap_4) {

// # Output table : 'copyOfduplicated'
									copyOfduplicated_tmp.id = 0;
									copyOfduplicated_tmp.codeCIS = row6.codeCIS;
									copyOfduplicated_tmp.designationPharmaceutique = row6.designation;
									copyOfduplicated_tmp.codeSubstance = row6.codeSubtance;
									copyOfduplicated_tmp.denominationSubstance = row6.denomination;
									copyOfduplicated_tmp.dosageSubstance = row6.dosage;
									copyOfduplicated_tmp.refDosage = row6.ref;
									copyOfduplicated_tmp.estActif = row6.nature;
									copyOfduplicated_tmp.numCompo = row6.num;
									copyOfduplicated = copyOfduplicated_tmp;
								} // closing inner join bracket (1)
// ###### START REJECTS ##### 

// # Output reject table : 'primaryFail'
// # Filter conditions 
								if (rejectedInnerJoin_tMap_4) {
									primaryFail_tmp.codeCIS = row6.codeCIS;
									primaryFail = primaryFail_tmp;
								} // closing filter/reject
// ###############################

							} // end of Var scope

							rejectedInnerJoin_tMap_4 = false;

							tos_count_tMap_4++;

							/**
							 * [tMap_4 main ] stop
							 */

							/**
							 * [tMap_4 process_data_begin ] start
							 */

							currentComponent = "tMap_4";

							/**
							 * [tMap_4 process_data_begin ] stop
							 */
// Start of branch "copyOfduplicated"
							if (copyOfduplicated != null) {

								/**
								 * [tDBOutput_4 main ] start
								 */

								currentComponent = "tDBOutput_4";

								if (execStat) {
									runStat.updateStatOnConnection(iterateId, 1, 1

											, "copyOfduplicated"

									);
								}

								whetherReject_tDBOutput_4 = false;
								pstmt_tDBOutput_4.setInt(1, copyOfduplicated.id);

								if (copyOfduplicated.codeCIS == null) {
									pstmt_tDBOutput_4.setNull(2, java.sql.Types.VARCHAR);
								} else {
									pstmt_tDBOutput_4.setString(2, copyOfduplicated.codeCIS);
								}

								if (copyOfduplicated.designationPharmaceutique == null) {
									pstmt_tDBOutput_4.setNull(3, java.sql.Types.VARCHAR);
								} else {
									pstmt_tDBOutput_4.setString(3, copyOfduplicated.designationPharmaceutique);
								}

								if (copyOfduplicated.codeSubstance == null) {
									pstmt_tDBOutput_4.setNull(4, java.sql.Types.VARCHAR);
								} else {
									pstmt_tDBOutput_4.setString(4, copyOfduplicated.codeSubstance);
								}

								if (copyOfduplicated.denominationSubstance == null) {
									pstmt_tDBOutput_4.setNull(5, java.sql.Types.VARCHAR);
								} else {
									pstmt_tDBOutput_4.setString(5, copyOfduplicated.denominationSubstance);
								}

								if (copyOfduplicated.dosageSubstance == null) {
									pstmt_tDBOutput_4.setNull(6, java.sql.Types.VARCHAR);
								} else {
									pstmt_tDBOutput_4.setString(6, copyOfduplicated.dosageSubstance);
								}

								if (copyOfduplicated.refDosage == null) {
									pstmt_tDBOutput_4.setNull(7, java.sql.Types.VARCHAR);
								} else {
									pstmt_tDBOutput_4.setString(7, copyOfduplicated.refDosage);
								}

								if (copyOfduplicated.estActif == null) {
									pstmt_tDBOutput_4.setNull(8, java.sql.Types.VARCHAR);
								} else {
									pstmt_tDBOutput_4.setString(8, copyOfduplicated.estActif);
								}

								if (copyOfduplicated.numCompo == null) {
									pstmt_tDBOutput_4.setNull(9, java.sql.Types.VARCHAR);
								} else {
									pstmt_tDBOutput_4.setString(9, copyOfduplicated.numCompo);
								}

								pstmt_tDBOutput_4.addBatch();
								nb_line_tDBOutput_4++;

								batchSizeCounter_tDBOutput_4++;
								if (batchSize_tDBOutput_4 <= batchSizeCounter_tDBOutput_4) {
									try {
										int countSum_tDBOutput_4 = 0;
										for (int countEach_tDBOutput_4 : pstmt_tDBOutput_4.executeBatch()) {
											countSum_tDBOutput_4 += (countEach_tDBOutput_4 == java.sql.Statement.EXECUTE_FAILED
													? 0
													: 1);
										}
										rowsToCommitCount_tDBOutput_4 += countSum_tDBOutput_4;
										insertedCount_tDBOutput_4 += countSum_tDBOutput_4;
									} catch (java.sql.BatchUpdateException e) {
										globalMap.put("tDBOutput_4_ERROR_MESSAGE", e.getMessage());
										int countSum_tDBOutput_4 = 0;
										for (int countEach_tDBOutput_4 : e.getUpdateCounts()) {
											countSum_tDBOutput_4 += (countEach_tDBOutput_4 < 0 ? 0
													: countEach_tDBOutput_4);
										}
										rowsToCommitCount_tDBOutput_4 += countSum_tDBOutput_4;
										insertedCount_tDBOutput_4 += countSum_tDBOutput_4;
										System.err.println(e.getMessage());
									}

									batchSizeCounter_tDBOutput_4 = 0;
								}
								commitCounter_tDBOutput_4++;

								if (commitEvery_tDBOutput_4 <= commitCounter_tDBOutput_4) {

									try {
										int countSum_tDBOutput_4 = 0;
										for (int countEach_tDBOutput_4 : pstmt_tDBOutput_4.executeBatch()) {
											countSum_tDBOutput_4 += (countEach_tDBOutput_4 < 0 ? 0 : 1);
										}
										rowsToCommitCount_tDBOutput_4 += countSum_tDBOutput_4;
										insertedCount_tDBOutput_4 += countSum_tDBOutput_4;
									} catch (java.sql.BatchUpdateException e) {
										globalMap.put("tDBOutput_4_ERROR_MESSAGE", e.getMessage());
										int countSum_tDBOutput_4 = 0;
										for (int countEach_tDBOutput_4 : e.getUpdateCounts()) {
											countSum_tDBOutput_4 += (countEach_tDBOutput_4 < 0 ? 0
													: countEach_tDBOutput_4);
										}
										rowsToCommitCount_tDBOutput_4 += countSum_tDBOutput_4;
										insertedCount_tDBOutput_4 += countSum_tDBOutput_4;
										System.err.println(e.getMessage());

									}
									if (rowsToCommitCount_tDBOutput_4 != 0) {
									}
									conn_tDBOutput_4.commit();
									if (rowsToCommitCount_tDBOutput_4 != 0) {
										rowsToCommitCount_tDBOutput_4 = 0;
									}
									commitCounter_tDBOutput_4 = 0;

								}

								tos_count_tDBOutput_4++;

								/**
								 * [tDBOutput_4 main ] stop
								 */

								/**
								 * [tDBOutput_4 process_data_begin ] start
								 */

								currentComponent = "tDBOutput_4";

								/**
								 * [tDBOutput_4 process_data_begin ] stop
								 */

								/**
								 * [tDBOutput_4 process_data_end ] start
								 */

								currentComponent = "tDBOutput_4";

								/**
								 * [tDBOutput_4 process_data_end ] stop
								 */

							} // End of branch "copyOfduplicated"

// Start of branch "primaryFail"
							if (primaryFail != null) {

								/**
								 * [tFileOutputDelimited_3 main ] start
								 */

								currentComponent = "tFileOutputDelimited_3";

								if (execStat) {
									runStat.updateStatOnConnection(iterateId, 1, 1

											, "primaryFail"

									);
								}

								StringBuilder sb_tFileOutputDelimited_3 = new StringBuilder();
								if (primaryFail.codeCIS != null) {
									sb_tFileOutputDelimited_3.append(primaryFail.codeCIS);
								}
								sb_tFileOutputDelimited_3.append(OUT_DELIM_ROWSEP_tFileOutputDelimited_3);

								nb_line_tFileOutputDelimited_3++;
								resourceMap.put("nb_line_tFileOutputDelimited_3", nb_line_tFileOutputDelimited_3);

								outtFileOutputDelimited_3.write(sb_tFileOutputDelimited_3.toString());

								tos_count_tFileOutputDelimited_3++;

								/**
								 * [tFileOutputDelimited_3 main ] stop
								 */

								/**
								 * [tFileOutputDelimited_3 process_data_begin ] start
								 */

								currentComponent = "tFileOutputDelimited_3";

								/**
								 * [tFileOutputDelimited_3 process_data_begin ] stop
								 */

								/**
								 * [tFileOutputDelimited_3 process_data_end ] start
								 */

								currentComponent = "tFileOutputDelimited_3";

								/**
								 * [tFileOutputDelimited_3 process_data_end ] stop
								 */

							} // End of branch "primaryFail"

							/**
							 * [tMap_4 process_data_end ] start
							 */

							currentComponent = "tMap_4";

							/**
							 * [tMap_4 process_data_end ] stop
							 */

						} // End of branch "row6"

						/**
						 * [tFileInputDelimited_4 process_data_end ] start
						 */

						currentComponent = "tFileInputDelimited_4";

						/**
						 * [tFileInputDelimited_4 process_data_end ] stop
						 */

						/**
						 * [tFileInputDelimited_4 end ] start
						 */

						currentComponent = "tFileInputDelimited_4";

					}
				} finally {
					if (!((Object) ("C:/Users/Ethan/Documents/workspace/GROMED/data/fichiers/CIS_COMPO_bdpm.txt") instanceof java.io.InputStream)) {
						if (fid_tFileInputDelimited_4 != null) {
							fid_tFileInputDelimited_4.close();
						}
					}
					if (fid_tFileInputDelimited_4 != null) {
						globalMap.put("tFileInputDelimited_4_NB_LINE", fid_tFileInputDelimited_4.getRowNumber());

					}
				}

				ok_Hash.put("tFileInputDelimited_4", true);
				end_Hash.put("tFileInputDelimited_4", System.currentTimeMillis());

				/**
				 * [tFileInputDelimited_4 end ] stop
				 */

				/**
				 * [tMap_4 end ] start
				 */

				currentComponent = "tMap_4";

// ###############################
// # Lookup hashes releasing
				if (tHash_Lookup_row7 != null) {
					tHash_Lookup_row7.endGet();
				}
				globalMap.remove("tHash_Lookup_row7");

// ###############################      

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row6");
				}

				ok_Hash.put("tMap_4", true);
				end_Hash.put("tMap_4", System.currentTimeMillis());

				/**
				 * [tMap_4 end ] stop
				 */

				/**
				 * [tDBOutput_4 end ] start
				 */

				currentComponent = "tDBOutput_4";

				try {
					if (batchSizeCounter_tDBOutput_4 != 0) {
						int countSum_tDBOutput_4 = 0;

						for (int countEach_tDBOutput_4 : pstmt_tDBOutput_4.executeBatch()) {
							countSum_tDBOutput_4 += (countEach_tDBOutput_4 == java.sql.Statement.EXECUTE_FAILED ? 0
									: 1);
						}
						rowsToCommitCount_tDBOutput_4 += countSum_tDBOutput_4;

						insertedCount_tDBOutput_4 += countSum_tDBOutput_4;

					}

				} catch (java.sql.BatchUpdateException e) {
					globalMap.put(currentComponent + "_ERROR_MESSAGE", e.getMessage());

					int countSum_tDBOutput_4 = 0;
					for (int countEach_tDBOutput_4 : e.getUpdateCounts()) {
						countSum_tDBOutput_4 += (countEach_tDBOutput_4 < 0 ? 0 : countEach_tDBOutput_4);
					}
					rowsToCommitCount_tDBOutput_4 += countSum_tDBOutput_4;

					insertedCount_tDBOutput_4 += countSum_tDBOutput_4;

					System.err.println(e.getMessage());

				}
				batchSizeCounter_tDBOutput_4 = 0;

				if (pstmt_tDBOutput_4 != null) {

					pstmt_tDBOutput_4.close();
					resourceMap.remove("pstmt_tDBOutput_4");

				}
				resourceMap.put("statementClosed_tDBOutput_4", true);
				if (commitCounter_tDBOutput_4 > 0 && rowsToCommitCount_tDBOutput_4 != 0) {

				}
				conn_tDBOutput_4.commit();
				if (commitCounter_tDBOutput_4 > 0 && rowsToCommitCount_tDBOutput_4 != 0) {

					rowsToCommitCount_tDBOutput_4 = 0;
				}
				commitCounter_tDBOutput_4 = 0;

				conn_tDBOutput_4.close();

				resourceMap.put("finish_tDBOutput_4", true);

				nb_line_deleted_tDBOutput_4 = nb_line_deleted_tDBOutput_4 + deletedCount_tDBOutput_4;
				nb_line_update_tDBOutput_4 = nb_line_update_tDBOutput_4 + updatedCount_tDBOutput_4;
				nb_line_inserted_tDBOutput_4 = nb_line_inserted_tDBOutput_4 + insertedCount_tDBOutput_4;
				nb_line_rejected_tDBOutput_4 = nb_line_rejected_tDBOutput_4 + rejectedCount_tDBOutput_4;

				globalMap.put("tDBOutput_4_NB_LINE", nb_line_tDBOutput_4);
				globalMap.put("tDBOutput_4_NB_LINE_UPDATED", nb_line_update_tDBOutput_4);
				globalMap.put("tDBOutput_4_NB_LINE_INSERTED", nb_line_inserted_tDBOutput_4);
				globalMap.put("tDBOutput_4_NB_LINE_DELETED", nb_line_deleted_tDBOutput_4);
				globalMap.put("tDBOutput_4_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_4);

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "copyOfduplicated");
				}

				ok_Hash.put("tDBOutput_4", true);
				end_Hash.put("tDBOutput_4", System.currentTimeMillis());

				/**
				 * [tDBOutput_4 end ] stop
				 */

				/**
				 * [tFileOutputDelimited_3 end ] start
				 */

				currentComponent = "tFileOutputDelimited_3";

				if (outtFileOutputDelimited_3 != null) {
					outtFileOutputDelimited_3.flush();
					outtFileOutputDelimited_3.close();
				}

				globalMap.put("tFileOutputDelimited_3_NB_LINE", nb_line_tFileOutputDelimited_3);
				globalMap.put("tFileOutputDelimited_3_FILE_NAME", fileName_tFileOutputDelimited_3);

				resourceMap.put("finish_tFileOutputDelimited_3", true);

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "primaryFail");
				}

				ok_Hash.put("tFileOutputDelimited_3", true);
				end_Hash.put("tFileOutputDelimited_3", System.currentTimeMillis());

				/**
				 * [tFileOutputDelimited_3 end ] stop
				 */

			} // end the resume

			if (resumeEntryMethodName == null || globalResumeTicket) {
				resumeUtil.addLog("CHECKPOINT", "CONNECTION:SUBJOB_OK:tFileInputDelimited_4:OnSubjobOk", "",
						Thread.currentThread().getId() + "", "", "", "", "", "");
			}

			if (execStat) {
				runStat.updateStatOnConnection("OnSubjobOk4", 0, "ok");
			}

			tFileInputDelimited_5Process(globalMap);

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			// free memory for "tMap_4"
			globalMap.remove("tHash_Lookup_row7");

			try {

				/**
				 * [tFileInputDelimited_4 finally ] start
				 */

				currentComponent = "tFileInputDelimited_4";

				/**
				 * [tFileInputDelimited_4 finally ] stop
				 */

				/**
				 * [tMap_4 finally ] start
				 */

				currentComponent = "tMap_4";

				/**
				 * [tMap_4 finally ] stop
				 */

				/**
				 * [tDBOutput_4 finally ] start
				 */

				currentComponent = "tDBOutput_4";

				try {
					if (resourceMap.get("statementClosed_tDBOutput_4") == null) {
						java.sql.PreparedStatement pstmtToClose_tDBOutput_4 = null;
						if ((pstmtToClose_tDBOutput_4 = (java.sql.PreparedStatement) resourceMap
								.remove("pstmt_tDBOutput_4")) != null) {
							pstmtToClose_tDBOutput_4.close();
						}
					}
				} finally {
					if (resourceMap.get("finish_tDBOutput_4") == null) {
						java.sql.Connection ctn_tDBOutput_4 = null;
						if ((ctn_tDBOutput_4 = (java.sql.Connection) resourceMap.get("conn_tDBOutput_4")) != null) {
							try {
								ctn_tDBOutput_4.close();
							} catch (java.sql.SQLException sqlEx_tDBOutput_4) {
								String errorMessage_tDBOutput_4 = "failed to close the connection in tDBOutput_4 :"
										+ sqlEx_tDBOutput_4.getMessage();
								System.err.println(errorMessage_tDBOutput_4);
							}
						}
					}
				}

				/**
				 * [tDBOutput_4 finally ] stop
				 */

				/**
				 * [tFileOutputDelimited_3 finally ] start
				 */

				currentComponent = "tFileOutputDelimited_3";

				if (resourceMap.get("finish_tFileOutputDelimited_3") == null) {

					java.io.Writer outtFileOutputDelimited_3 = (java.io.Writer) resourceMap
							.get("out_tFileOutputDelimited_3");
					if (outtFileOutputDelimited_3 != null) {
						outtFileOutputDelimited_3.flush();
						outtFileOutputDelimited_3.close();
					}

				}

				/**
				 * [tFileOutputDelimited_3 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tFileInputDelimited_4_SUBPROCESS_STATE", 1);
	}

	public static class copyOfcopyOfduplicatedStruct
			implements routines.system.IPersistableRow<copyOfcopyOfduplicatedStruct> {
		final static byte[] commonByteArrayLock_GROMED_dump_gros_med_brut = new byte[0];
		static byte[] commonByteArray_GROMED_dump_gros_med_brut = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public String idGenerique;

		public String getIdGenerique() {
			return this.idGenerique;
		}

		public String libelleGenerique;

		public String getLibelleGenerique() {
			return this.libelleGenerique;
		}

		public String codeCIS;

		public String getCodeCIS() {
			return this.codeCIS;
		}

		public String typeGenerique;

		public String getTypeGenerique() {
			return this.typeGenerique;
		}

		public String groupeGenerique;

		public String getGroupeGenerique() {
			return this.groupeGenerique;
		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + ((this.codeCIS == null) ? 0 : this.codeCIS.hashCode());

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final copyOfcopyOfduplicatedStruct other = (copyOfcopyOfduplicatedStruct) obj;

			if (this.codeCIS == null) {
				if (other.codeCIS != null)
					return false;

			} else if (!this.codeCIS.equals(other.codeCIS))

				return false;

			return true;
		}

		public void copyDataTo(copyOfcopyOfduplicatedStruct other) {

			other.idGenerique = this.idGenerique;
			other.libelleGenerique = this.libelleGenerique;
			other.codeCIS = this.codeCIS;
			other.typeGenerique = this.typeGenerique;
			other.groupeGenerique = this.groupeGenerique;

		}

		public void copyKeysDataTo(copyOfcopyOfduplicatedStruct other) {

			other.codeCIS = this.codeCIS;

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_GROMED_dump_gros_med_brut.length) {
					if (length < 1024 && commonByteArray_GROMED_dump_gros_med_brut.length == 0) {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[1024];
					} else {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_GROMED_dump_gros_med_brut, 0, length);
				strReturn = new String(commonByteArray_GROMED_dump_gros_med_brut, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_GROMED_dump_gros_med_brut.length) {
					if (length < 1024 && commonByteArray_GROMED_dump_gros_med_brut.length == 0) {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[1024];
					} else {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_GROMED_dump_gros_med_brut, 0, length);
				strReturn = new String(commonByteArray_GROMED_dump_gros_med_brut, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_GROMED_dump_gros_med_brut) {

				try {

					int length = 0;

					this.idGenerique = readString(dis);

					this.libelleGenerique = readString(dis);

					this.codeCIS = readString(dis);

					this.typeGenerique = readString(dis);

					this.groupeGenerique = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_GROMED_dump_gros_med_brut) {

				try {

					int length = 0;

					this.idGenerique = readString(dis);

					this.libelleGenerique = readString(dis);

					this.codeCIS = readString(dis);

					this.typeGenerique = readString(dis);

					this.groupeGenerique = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.idGenerique, dos);

				// String

				writeString(this.libelleGenerique, dos);

				// String

				writeString(this.codeCIS, dos);

				// String

				writeString(this.typeGenerique, dos);

				// String

				writeString(this.groupeGenerique, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.idGenerique, dos);

				// String

				writeString(this.libelleGenerique, dos);

				// String

				writeString(this.codeCIS, dos);

				// String

				writeString(this.typeGenerique, dos);

				// String

				writeString(this.groupeGenerique, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("idGenerique=" + idGenerique);
			sb.append(",libelleGenerique=" + libelleGenerique);
			sb.append(",codeCIS=" + codeCIS);
			sb.append(",typeGenerique=" + typeGenerique);
			sb.append(",groupeGenerique=" + groupeGenerique);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(copyOfcopyOfduplicatedStruct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.codeCIS, other.codeCIS);
			if (returnValue != 0) {
				return returnValue;
			}

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class copyOfprimaryFailStruct implements routines.system.IPersistableRow<copyOfprimaryFailStruct> {
		final static byte[] commonByteArrayLock_GROMED_dump_gros_med_brut = new byte[0];
		static byte[] commonByteArray_GROMED_dump_gros_med_brut = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public String CodeCIS;

		public String getCodeCIS() {
			return this.CodeCIS;
		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + ((this.CodeCIS == null) ? 0 : this.CodeCIS.hashCode());

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final copyOfprimaryFailStruct other = (copyOfprimaryFailStruct) obj;

			if (this.CodeCIS == null) {
				if (other.CodeCIS != null)
					return false;

			} else if (!this.CodeCIS.equals(other.CodeCIS))

				return false;

			return true;
		}

		public void copyDataTo(copyOfprimaryFailStruct other) {

			other.CodeCIS = this.CodeCIS;

		}

		public void copyKeysDataTo(copyOfprimaryFailStruct other) {

			other.CodeCIS = this.CodeCIS;

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_GROMED_dump_gros_med_brut.length) {
					if (length < 1024 && commonByteArray_GROMED_dump_gros_med_brut.length == 0) {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[1024];
					} else {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_GROMED_dump_gros_med_brut, 0, length);
				strReturn = new String(commonByteArray_GROMED_dump_gros_med_brut, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_GROMED_dump_gros_med_brut.length) {
					if (length < 1024 && commonByteArray_GROMED_dump_gros_med_brut.length == 0) {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[1024];
					} else {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_GROMED_dump_gros_med_brut, 0, length);
				strReturn = new String(commonByteArray_GROMED_dump_gros_med_brut, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_GROMED_dump_gros_med_brut) {

				try {

					int length = 0;

					this.CodeCIS = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_GROMED_dump_gros_med_brut) {

				try {

					int length = 0;

					this.CodeCIS = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.CodeCIS, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.CodeCIS, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("CodeCIS=" + CodeCIS);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(copyOfprimaryFailStruct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.CodeCIS, other.CodeCIS);
			if (returnValue != 0) {
				return returnValue;
			}

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class row8Struct implements routines.system.IPersistableRow<row8Struct> {
		final static byte[] commonByteArrayLock_GROMED_dump_gros_med_brut = new byte[0];
		static byte[] commonByteArray_GROMED_dump_gros_med_brut = new byte[0];

		public Integer id;

		public Integer getId() {
			return this.id;
		}

		public String libelle;

		public String getLibelle() {
			return this.libelle;
		}

		public String CodeCISc;

		public String getCodeCISc() {
			return this.CodeCISc;
		}

		public String type;

		public String getType() {
			return this.type;
		}

		public String num;

		public String getNum() {
			return this.num;
		}

		public String Column5;

		public String getColumn5() {
			return this.Column5;
		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_GROMED_dump_gros_med_brut.length) {
					if (length < 1024 && commonByteArray_GROMED_dump_gros_med_brut.length == 0) {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[1024];
					} else {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_GROMED_dump_gros_med_brut, 0, length);
				strReturn = new String(commonByteArray_GROMED_dump_gros_med_brut, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_GROMED_dump_gros_med_brut.length) {
					if (length < 1024 && commonByteArray_GROMED_dump_gros_med_brut.length == 0) {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[1024];
					} else {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_GROMED_dump_gros_med_brut, 0, length);
				strReturn = new String(commonByteArray_GROMED_dump_gros_med_brut, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_GROMED_dump_gros_med_brut) {

				try {

					int length = 0;

					this.id = readInteger(dis);

					this.libelle = readString(dis);

					this.CodeCISc = readString(dis);

					this.type = readString(dis);

					this.num = readString(dis);

					this.Column5 = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_GROMED_dump_gros_med_brut) {

				try {

					int length = 0;

					this.id = readInteger(dis);

					this.libelle = readString(dis);

					this.CodeCISc = readString(dis);

					this.type = readString(dis);

					this.num = readString(dis);

					this.Column5 = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// Integer

				writeInteger(this.id, dos);

				// String

				writeString(this.libelle, dos);

				// String

				writeString(this.CodeCISc, dos);

				// String

				writeString(this.type, dos);

				// String

				writeString(this.num, dos);

				// String

				writeString(this.Column5, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// Integer

				writeInteger(this.id, dos);

				// String

				writeString(this.libelle, dos);

				// String

				writeString(this.CodeCISc, dos);

				// String

				writeString(this.type, dos);

				// String

				writeString(this.num, dos);

				// String

				writeString(this.Column5, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("id=" + String.valueOf(id));
			sb.append(",libelle=" + libelle);
			sb.append(",CodeCISc=" + CodeCISc);
			sb.append(",type=" + type);
			sb.append(",num=" + num);
			sb.append(",Column5=" + Column5);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row8Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class after_tFileInputDelimited_5Struct
			implements routines.system.IPersistableRow<after_tFileInputDelimited_5Struct> {
		final static byte[] commonByteArrayLock_GROMED_dump_gros_med_brut = new byte[0];
		static byte[] commonByteArray_GROMED_dump_gros_med_brut = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public Integer id;

		public Integer getId() {
			return this.id;
		}

		public String libelle;

		public String getLibelle() {
			return this.libelle;
		}

		public String CodeCISc;

		public String getCodeCISc() {
			return this.CodeCISc;
		}

		public String type;

		public String getType() {
			return this.type;
		}

		public String num;

		public String getNum() {
			return this.num;
		}

		public String Column5;

		public String getColumn5() {
			return this.Column5;
		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + ((this.CodeCISc == null) ? 0 : this.CodeCISc.hashCode());

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final after_tFileInputDelimited_5Struct other = (after_tFileInputDelimited_5Struct) obj;

			if (this.CodeCISc == null) {
				if (other.CodeCISc != null)
					return false;

			} else if (!this.CodeCISc.equals(other.CodeCISc))

				return false;

			return true;
		}

		public void copyDataTo(after_tFileInputDelimited_5Struct other) {

			other.id = this.id;
			other.libelle = this.libelle;
			other.CodeCISc = this.CodeCISc;
			other.type = this.type;
			other.num = this.num;
			other.Column5 = this.Column5;

		}

		public void copyKeysDataTo(after_tFileInputDelimited_5Struct other) {

			other.CodeCISc = this.CodeCISc;

		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_GROMED_dump_gros_med_brut.length) {
					if (length < 1024 && commonByteArray_GROMED_dump_gros_med_brut.length == 0) {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[1024];
					} else {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_GROMED_dump_gros_med_brut, 0, length);
				strReturn = new String(commonByteArray_GROMED_dump_gros_med_brut, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_GROMED_dump_gros_med_brut.length) {
					if (length < 1024 && commonByteArray_GROMED_dump_gros_med_brut.length == 0) {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[1024];
					} else {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_GROMED_dump_gros_med_brut, 0, length);
				strReturn = new String(commonByteArray_GROMED_dump_gros_med_brut, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_GROMED_dump_gros_med_brut) {

				try {

					int length = 0;

					this.id = readInteger(dis);

					this.libelle = readString(dis);

					this.CodeCISc = readString(dis);

					this.type = readString(dis);

					this.num = readString(dis);

					this.Column5 = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_GROMED_dump_gros_med_brut) {

				try {

					int length = 0;

					this.id = readInteger(dis);

					this.libelle = readString(dis);

					this.CodeCISc = readString(dis);

					this.type = readString(dis);

					this.num = readString(dis);

					this.Column5 = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// Integer

				writeInteger(this.id, dos);

				// String

				writeString(this.libelle, dos);

				// String

				writeString(this.CodeCISc, dos);

				// String

				writeString(this.type, dos);

				// String

				writeString(this.num, dos);

				// String

				writeString(this.Column5, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// Integer

				writeInteger(this.id, dos);

				// String

				writeString(this.libelle, dos);

				// String

				writeString(this.CodeCISc, dos);

				// String

				writeString(this.type, dos);

				// String

				writeString(this.num, dos);

				// String

				writeString(this.Column5, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("id=" + String.valueOf(id));
			sb.append(",libelle=" + libelle);
			sb.append(",CodeCISc=" + CodeCISc);
			sb.append(",type=" + type);
			sb.append(",num=" + num);
			sb.append(",Column5=" + Column5);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(after_tFileInputDelimited_5Struct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.CodeCISc, other.CodeCISc);
			if (returnValue != 0) {
				return returnValue;
			}

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public void tFileInputDelimited_5Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tFileInputDelimited_5_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				tDBInput_4Process(globalMap);

				row8Struct row8 = new row8Struct();
				copyOfcopyOfduplicatedStruct copyOfcopyOfduplicated = new copyOfcopyOfduplicatedStruct();
				copyOfprimaryFailStruct copyOfprimaryFail = new copyOfprimaryFailStruct();

				/**
				 * [tDBOutput_5 begin ] start
				 */

				ok_Hash.put("tDBOutput_5", false);
				start_Hash.put("tDBOutput_5", System.currentTimeMillis());

				currentComponent = "tDBOutput_5";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "copyOfcopyOfduplicated");
				}

				int tos_count_tDBOutput_5 = 0;

				int nb_line_tDBOutput_5 = 0;
				int nb_line_update_tDBOutput_5 = 0;
				int nb_line_inserted_tDBOutput_5 = 0;
				int nb_line_deleted_tDBOutput_5 = 0;
				int nb_line_rejected_tDBOutput_5 = 0;

				int deletedCount_tDBOutput_5 = 0;
				int updatedCount_tDBOutput_5 = 0;
				int insertedCount_tDBOutput_5 = 0;
				int rowsToCommitCount_tDBOutput_5 = 0;
				int rejectedCount_tDBOutput_5 = 0;

				String tableName_tDBOutput_5 = "cis_gener_bdpm";
				boolean whetherReject_tDBOutput_5 = false;

				java.util.Calendar calendar_tDBOutput_5 = java.util.Calendar.getInstance();
				calendar_tDBOutput_5.set(1, 0, 1, 0, 0, 0);
				long year1_tDBOutput_5 = calendar_tDBOutput_5.getTime().getTime();
				calendar_tDBOutput_5.set(10000, 0, 1, 0, 0, 0);
				long year10000_tDBOutput_5 = calendar_tDBOutput_5.getTime().getTime();
				long date_tDBOutput_5;

				java.sql.Connection conn_tDBOutput_5 = null;

				String properties_tDBOutput_5 = context.gros_med_brut1_AdditionalParams;
				if (properties_tDBOutput_5 == null || properties_tDBOutput_5.trim().length() == 0) {
					properties_tDBOutput_5 = "rewriteBatchedStatements=true&allowLoadLocalInfile=true";
				} else {
					if (!properties_tDBOutput_5.contains("rewriteBatchedStatements=")) {
						properties_tDBOutput_5 += "&rewriteBatchedStatements=true";
					}

					if (!properties_tDBOutput_5.contains("allowLoadLocalInfile=")) {
						properties_tDBOutput_5 += "&allowLoadLocalInfile=true";
					}
				}

				String url_tDBOutput_5 = "jdbc:mariadb://" + context.gros_med_brut1_Server + ":"
						+ context.gros_med_brut1_Port + "/" + context.gros_med_brut1_Database + "?"
						+ properties_tDBOutput_5;

				String driverClass_tDBOutput_5 = "org.mariadb.jdbc.Driver";

				String dbUser_tDBOutput_5 = context.gros_med_brut1_Login;

				final String decryptedPassword_tDBOutput_5 = context.gros_med_brut1_Password;

				String dbPwd_tDBOutput_5 = decryptedPassword_tDBOutput_5;
				java.lang.Class.forName(driverClass_tDBOutput_5);

				conn_tDBOutput_5 = java.sql.DriverManager.getConnection(url_tDBOutput_5, dbUser_tDBOutput_5,
						dbPwd_tDBOutput_5);

				resourceMap.put("conn_tDBOutput_5", conn_tDBOutput_5);
				conn_tDBOutput_5.setAutoCommit(false);
				int commitEvery_tDBOutput_5 = 10000;
				int commitCounter_tDBOutput_5 = 0;

				int count_tDBOutput_5 = 0;

				try (java.sql.Statement stmtClear_tDBOutput_5 = conn_tDBOutput_5.createStatement()) {
					stmtClear_tDBOutput_5.executeUpdate("DELETE FROM `" + tableName_tDBOutput_5 + "`");
				}

				String insert_tDBOutput_5 = "INSERT INTO `" + "cis_gener_bdpm"
						+ "` (`idGenerique`,`libelleGenerique`,`codeCIS`,`typeGenerique`,`groupeGenerique`) VALUES (?,?,?,?,?)";
				int batchSize_tDBOutput_5 = 100;
				int batchSizeCounter_tDBOutput_5 = 0;

				java.sql.PreparedStatement pstmt_tDBOutput_5 = conn_tDBOutput_5.prepareStatement(insert_tDBOutput_5);
				resourceMap.put("pstmt_tDBOutput_5", pstmt_tDBOutput_5);

				/**
				 * [tDBOutput_5 begin ] stop
				 */

				/**
				 * [tFileOutputDelimited_4 begin ] start
				 */

				ok_Hash.put("tFileOutputDelimited_4", false);
				start_Hash.put("tFileOutputDelimited_4", System.currentTimeMillis());

				currentComponent = "tFileOutputDelimited_4";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "copyOfprimaryFail");
				}

				int tos_count_tFileOutputDelimited_4 = 0;

				String fileName_tFileOutputDelimited_4 = "";
				fileName_tFileOutputDelimited_4 = (new java.io.File(
						context.source + "log/cis_gener_bdpm_Unknow_Primarykey.log")).getAbsolutePath().replace("\\",
								"/");
				String fullName_tFileOutputDelimited_4 = null;
				String extension_tFileOutputDelimited_4 = null;
				String directory_tFileOutputDelimited_4 = null;
				if ((fileName_tFileOutputDelimited_4.indexOf("/") != -1)) {
					if (fileName_tFileOutputDelimited_4.lastIndexOf(".") < fileName_tFileOutputDelimited_4
							.lastIndexOf("/")) {
						fullName_tFileOutputDelimited_4 = fileName_tFileOutputDelimited_4;
						extension_tFileOutputDelimited_4 = "";
					} else {
						fullName_tFileOutputDelimited_4 = fileName_tFileOutputDelimited_4.substring(0,
								fileName_tFileOutputDelimited_4.lastIndexOf("."));
						extension_tFileOutputDelimited_4 = fileName_tFileOutputDelimited_4
								.substring(fileName_tFileOutputDelimited_4.lastIndexOf("."));
					}
					directory_tFileOutputDelimited_4 = fileName_tFileOutputDelimited_4.substring(0,
							fileName_tFileOutputDelimited_4.lastIndexOf("/"));
				} else {
					if (fileName_tFileOutputDelimited_4.lastIndexOf(".") != -1) {
						fullName_tFileOutputDelimited_4 = fileName_tFileOutputDelimited_4.substring(0,
								fileName_tFileOutputDelimited_4.lastIndexOf("."));
						extension_tFileOutputDelimited_4 = fileName_tFileOutputDelimited_4
								.substring(fileName_tFileOutputDelimited_4.lastIndexOf("."));
					} else {
						fullName_tFileOutputDelimited_4 = fileName_tFileOutputDelimited_4;
						extension_tFileOutputDelimited_4 = "";
					}
					directory_tFileOutputDelimited_4 = "";
				}
				boolean isFileGenerated_tFileOutputDelimited_4 = true;
				java.io.File filetFileOutputDelimited_4 = new java.io.File(fileName_tFileOutputDelimited_4);
				globalMap.put("tFileOutputDelimited_4_FILE_NAME", fileName_tFileOutputDelimited_4);
				int nb_line_tFileOutputDelimited_4 = 0;
				int splitedFileNo_tFileOutputDelimited_4 = 0;
				int currentRow_tFileOutputDelimited_4 = 0;

				final String OUT_DELIM_tFileOutputDelimited_4 = /** Start field tFileOutputDelimited_4:FIELDSEPARATOR */
						";"/** End field tFileOutputDelimited_4:FIELDSEPARATOR */
				;

				final String OUT_DELIM_ROWSEP_tFileOutputDelimited_4 = /**
																		 * Start field
																		 * tFileOutputDelimited_4:ROWSEPARATOR
																		 */
						"\n"/** End field tFileOutputDelimited_4:ROWSEPARATOR */
				;

				// create directory only if not exists
				if (directory_tFileOutputDelimited_4 != null && directory_tFileOutputDelimited_4.trim().length() != 0) {
					java.io.File dir_tFileOutputDelimited_4 = new java.io.File(directory_tFileOutputDelimited_4);
					if (!dir_tFileOutputDelimited_4.exists()) {
						dir_tFileOutputDelimited_4.mkdirs();
					}
				}

				// routines.system.Row
				java.io.Writer outtFileOutputDelimited_4 = null;

				java.io.File fileToDelete_tFileOutputDelimited_4 = new java.io.File(fileName_tFileOutputDelimited_4);
				if (fileToDelete_tFileOutputDelimited_4.exists()) {
					fileToDelete_tFileOutputDelimited_4.delete();
				}
				outtFileOutputDelimited_4 = new java.io.BufferedWriter(new java.io.OutputStreamWriter(
						new java.io.FileOutputStream(fileName_tFileOutputDelimited_4, false), "ISO-8859-15"));

				resourceMap.put("out_tFileOutputDelimited_4", outtFileOutputDelimited_4);
				resourceMap.put("nb_line_tFileOutputDelimited_4", nb_line_tFileOutputDelimited_4);

				/**
				 * [tFileOutputDelimited_4 begin ] stop
				 */

				/**
				 * [tMap_5 begin ] start
				 */

				ok_Hash.put("tMap_5", false);
				start_Hash.put("tMap_5", System.currentTimeMillis());

				currentComponent = "tMap_5";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row8");
				}

				int tos_count_tMap_5 = 0;

// ###############################
// # Lookup's keys initialization

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row9Struct> tHash_Lookup_row9 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row9Struct>) ((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row9Struct>) globalMap
						.get("tHash_Lookup_row9"));

				row9Struct row9HashKey = new row9Struct();
				row9Struct row9Default = new row9Struct();
// ###############################        

// ###############################
// # Vars initialization
				class Var__tMap_5__Struct {
				}
				Var__tMap_5__Struct Var__tMap_5 = new Var__tMap_5__Struct();
// ###############################

// ###############################
// # Outputs initialization
				copyOfcopyOfduplicatedStruct copyOfcopyOfduplicated_tmp = new copyOfcopyOfduplicatedStruct();
				copyOfprimaryFailStruct copyOfprimaryFail_tmp = new copyOfprimaryFailStruct();
// ###############################

				/**
				 * [tMap_5 begin ] stop
				 */

				/**
				 * [tFileInputDelimited_5 begin ] start
				 */

				ok_Hash.put("tFileInputDelimited_5", false);
				start_Hash.put("tFileInputDelimited_5", System.currentTimeMillis());

				currentComponent = "tFileInputDelimited_5";

				int tos_count_tFileInputDelimited_5 = 0;

				final routines.system.RowState rowstate_tFileInputDelimited_5 = new routines.system.RowState();

				int nb_line_tFileInputDelimited_5 = 0;
				org.talend.fileprocess.FileInputDelimited fid_tFileInputDelimited_5 = null;
				int limit_tFileInputDelimited_5 = -1;
				try {

					Object filename_tFileInputDelimited_5 = "C:/Users/Ethan/Documents/workspace/GROMED/data/fichiers/CIS_GENER_bdpm.txt";
					if (filename_tFileInputDelimited_5 instanceof java.io.InputStream) {

						int footer_value_tFileInputDelimited_5 = 0, random_value_tFileInputDelimited_5 = -1;
						if (footer_value_tFileInputDelimited_5 > 0 || random_value_tFileInputDelimited_5 > 0) {
							throw new java.lang.Exception(
									"When the input source is a stream,footer and random shouldn't be bigger than 0.");
						}

					}
					try {
						fid_tFileInputDelimited_5 = new org.talend.fileprocess.FileInputDelimited(
								"C:/Users/Ethan/Documents/workspace/GROMED/data/fichiers/CIS_GENER_bdpm.txt",
								"ISO-8859-15", "\t", "\n", false, 0, 0, limit_tFileInputDelimited_5, -1, false);
					} catch (java.lang.Exception e) {
						globalMap.put("tFileInputDelimited_5_ERROR_MESSAGE", e.getMessage());

						System.err.println(e.getMessage());

					}

					while (fid_tFileInputDelimited_5 != null && fid_tFileInputDelimited_5.nextRecord()) {
						rowstate_tFileInputDelimited_5.reset();

						row8 = null;

						boolean whetherReject_tFileInputDelimited_5 = false;
						row8 = new row8Struct();
						try {

							int columnIndexWithD_tFileInputDelimited_5 = 0;

							String temp = "";

							columnIndexWithD_tFileInputDelimited_5 = 0;

							temp = fid_tFileInputDelimited_5.get(columnIndexWithD_tFileInputDelimited_5);
							if (temp.length() > 0) {

								try {

									row8.id = ParserUtils.parseTo_Integer(temp);

								} catch (java.lang.Exception ex_tFileInputDelimited_5) {
									globalMap.put("tFileInputDelimited_5_ERROR_MESSAGE",
											ex_tFileInputDelimited_5.getMessage());
									rowstate_tFileInputDelimited_5.setException(new RuntimeException(String.format(
											"Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
											"id", "row8", temp, ex_tFileInputDelimited_5), ex_tFileInputDelimited_5));
								}

							} else {

								row8.id = null;

							}

							columnIndexWithD_tFileInputDelimited_5 = 1;

							row8.libelle = fid_tFileInputDelimited_5.get(columnIndexWithD_tFileInputDelimited_5);

							columnIndexWithD_tFileInputDelimited_5 = 2;

							row8.CodeCISc = fid_tFileInputDelimited_5.get(columnIndexWithD_tFileInputDelimited_5);

							columnIndexWithD_tFileInputDelimited_5 = 3;

							row8.type = fid_tFileInputDelimited_5.get(columnIndexWithD_tFileInputDelimited_5);

							columnIndexWithD_tFileInputDelimited_5 = 4;

							row8.num = fid_tFileInputDelimited_5.get(columnIndexWithD_tFileInputDelimited_5);

							columnIndexWithD_tFileInputDelimited_5 = 5;

							row8.Column5 = fid_tFileInputDelimited_5.get(columnIndexWithD_tFileInputDelimited_5);

							if (rowstate_tFileInputDelimited_5.getException() != null) {
								throw rowstate_tFileInputDelimited_5.getException();
							}

						} catch (java.lang.Exception e) {
							globalMap.put("tFileInputDelimited_5_ERROR_MESSAGE", e.getMessage());
							whetherReject_tFileInputDelimited_5 = true;

							System.err.println(e.getMessage());
							row8 = null;

						}

						/**
						 * [tFileInputDelimited_5 begin ] stop
						 */

						/**
						 * [tFileInputDelimited_5 main ] start
						 */

						currentComponent = "tFileInputDelimited_5";

						tos_count_tFileInputDelimited_5++;

						/**
						 * [tFileInputDelimited_5 main ] stop
						 */

						/**
						 * [tFileInputDelimited_5 process_data_begin ] start
						 */

						currentComponent = "tFileInputDelimited_5";

						/**
						 * [tFileInputDelimited_5 process_data_begin ] stop
						 */
// Start of branch "row8"
						if (row8 != null) {

							/**
							 * [tMap_5 main ] start
							 */

							currentComponent = "tMap_5";

							if (execStat) {
								runStat.updateStatOnConnection(iterateId, 1, 1

										, "row8"

								);
							}

							boolean hasCasePrimitiveKeyWithNull_tMap_5 = false;

							// ###############################
							// # Input tables (lookups)
							boolean rejectedInnerJoin_tMap_5 = false;
							boolean mainRowRejected_tMap_5 = false;

							///////////////////////////////////////////////
							// Starting Lookup Table "row9"
							///////////////////////////////////////////////

							boolean forceLooprow9 = false;

							row9Struct row9ObjectFromLookup = null;

							if (!rejectedInnerJoin_tMap_5) { // G_TM_M_020

								hasCasePrimitiveKeyWithNull_tMap_5 = false;

								row9HashKey.codeCIS = row8.CodeCISc;

								row9HashKey.hashCodeDirty = true;

								tHash_Lookup_row9.lookup(row9HashKey);

								if (!tHash_Lookup_row9.hasNext()) { // G_TM_M_090

									rejectedInnerJoin_tMap_5 = true;

								} // G_TM_M_090

							} // G_TM_M_020

							if (tHash_Lookup_row9 != null && tHash_Lookup_row9.getCount(row9HashKey) > 1) { // G 071

								// System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row9'
								// and it contains more one result from keys : row9.codeCIS = '" +
								// row9HashKey.codeCIS + "'");
							} // G 071

							row9Struct row9 = null;

							row9Struct fromLookup_row9 = null;
							row9 = row9Default;

							if (tHash_Lookup_row9 != null && tHash_Lookup_row9.hasNext()) { // G 099

								fromLookup_row9 = tHash_Lookup_row9.next();

							} // G 099

							if (fromLookup_row9 != null) {
								row9 = fromLookup_row9;
							}

							// ###############################
							{ // start of Var scope

								// ###############################
								// # Vars tables

								Var__tMap_5__Struct Var = Var__tMap_5;// ###############################
								// ###############################
								// # Output tables

								copyOfcopyOfduplicated = null;
								copyOfprimaryFail = null;

								if (!rejectedInnerJoin_tMap_5) {

// # Output table : 'copyOfcopyOfduplicated'
									copyOfcopyOfduplicated_tmp.idGenerique = Integer.toString(row8.id);
									copyOfcopyOfduplicated_tmp.libelleGenerique = row8.libelle;
									copyOfcopyOfduplicated_tmp.codeCIS = row8.CodeCISc;
									copyOfcopyOfduplicated_tmp.typeGenerique = row8.type;
									copyOfcopyOfduplicated_tmp.groupeGenerique = row8.num;
									copyOfcopyOfduplicated = copyOfcopyOfduplicated_tmp;
								} // closing inner join bracket (1)
// ###### START REJECTS ##### 

// # Output reject table : 'copyOfprimaryFail'
// # Filter conditions 
								if (rejectedInnerJoin_tMap_5) {
									copyOfprimaryFail_tmp.CodeCIS = row8.CodeCISc;
									copyOfprimaryFail = copyOfprimaryFail_tmp;
								} // closing filter/reject
// ###############################

							} // end of Var scope

							rejectedInnerJoin_tMap_5 = false;

							tos_count_tMap_5++;

							/**
							 * [tMap_5 main ] stop
							 */

							/**
							 * [tMap_5 process_data_begin ] start
							 */

							currentComponent = "tMap_5";

							/**
							 * [tMap_5 process_data_begin ] stop
							 */
// Start of branch "copyOfcopyOfduplicated"
							if (copyOfcopyOfduplicated != null) {

								/**
								 * [tDBOutput_5 main ] start
								 */

								currentComponent = "tDBOutput_5";

								if (execStat) {
									runStat.updateStatOnConnection(iterateId, 1, 1

											, "copyOfcopyOfduplicated"

									);
								}

								whetherReject_tDBOutput_5 = false;
								if (copyOfcopyOfduplicated.idGenerique == null) {
									pstmt_tDBOutput_5.setNull(1, java.sql.Types.VARCHAR);
								} else {
									pstmt_tDBOutput_5.setString(1, copyOfcopyOfduplicated.idGenerique);
								}

								if (copyOfcopyOfduplicated.libelleGenerique == null) {
									pstmt_tDBOutput_5.setNull(2, java.sql.Types.VARCHAR);
								} else {
									pstmt_tDBOutput_5.setString(2, copyOfcopyOfduplicated.libelleGenerique);
								}

								if (copyOfcopyOfduplicated.codeCIS == null) {
									pstmt_tDBOutput_5.setNull(3, java.sql.Types.VARCHAR);
								} else {
									pstmt_tDBOutput_5.setString(3, copyOfcopyOfduplicated.codeCIS);
								}

								if (copyOfcopyOfduplicated.typeGenerique == null) {
									pstmt_tDBOutput_5.setNull(4, java.sql.Types.VARCHAR);
								} else {
									pstmt_tDBOutput_5.setString(4, copyOfcopyOfduplicated.typeGenerique);
								}

								if (copyOfcopyOfduplicated.groupeGenerique == null) {
									pstmt_tDBOutput_5.setNull(5, java.sql.Types.VARCHAR);
								} else {
									pstmt_tDBOutput_5.setString(5, copyOfcopyOfduplicated.groupeGenerique);
								}

								pstmt_tDBOutput_5.addBatch();
								nb_line_tDBOutput_5++;

								batchSizeCounter_tDBOutput_5++;
								if (batchSize_tDBOutput_5 <= batchSizeCounter_tDBOutput_5) {
									try {
										int countSum_tDBOutput_5 = 0;
										for (int countEach_tDBOutput_5 : pstmt_tDBOutput_5.executeBatch()) {
											countSum_tDBOutput_5 += (countEach_tDBOutput_5 == java.sql.Statement.EXECUTE_FAILED
													? 0
													: 1);
										}
										rowsToCommitCount_tDBOutput_5 += countSum_tDBOutput_5;
										insertedCount_tDBOutput_5 += countSum_tDBOutput_5;
									} catch (java.sql.BatchUpdateException e) {
										globalMap.put("tDBOutput_5_ERROR_MESSAGE", e.getMessage());
										int countSum_tDBOutput_5 = 0;
										for (int countEach_tDBOutput_5 : e.getUpdateCounts()) {
											countSum_tDBOutput_5 += (countEach_tDBOutput_5 < 0 ? 0
													: countEach_tDBOutput_5);
										}
										rowsToCommitCount_tDBOutput_5 += countSum_tDBOutput_5;
										insertedCount_tDBOutput_5 += countSum_tDBOutput_5;
										System.err.println(e.getMessage());
									}

									batchSizeCounter_tDBOutput_5 = 0;
								}
								commitCounter_tDBOutput_5++;

								if (commitEvery_tDBOutput_5 <= commitCounter_tDBOutput_5) {

									try {
										int countSum_tDBOutput_5 = 0;
										for (int countEach_tDBOutput_5 : pstmt_tDBOutput_5.executeBatch()) {
											countSum_tDBOutput_5 += (countEach_tDBOutput_5 < 0 ? 0 : 1);
										}
										rowsToCommitCount_tDBOutput_5 += countSum_tDBOutput_5;
										insertedCount_tDBOutput_5 += countSum_tDBOutput_5;
									} catch (java.sql.BatchUpdateException e) {
										globalMap.put("tDBOutput_5_ERROR_MESSAGE", e.getMessage());
										int countSum_tDBOutput_5 = 0;
										for (int countEach_tDBOutput_5 : e.getUpdateCounts()) {
											countSum_tDBOutput_5 += (countEach_tDBOutput_5 < 0 ? 0
													: countEach_tDBOutput_5);
										}
										rowsToCommitCount_tDBOutput_5 += countSum_tDBOutput_5;
										insertedCount_tDBOutput_5 += countSum_tDBOutput_5;
										System.err.println(e.getMessage());

									}
									if (rowsToCommitCount_tDBOutput_5 != 0) {
									}
									conn_tDBOutput_5.commit();
									if (rowsToCommitCount_tDBOutput_5 != 0) {
										rowsToCommitCount_tDBOutput_5 = 0;
									}
									commitCounter_tDBOutput_5 = 0;

								}

								tos_count_tDBOutput_5++;

								/**
								 * [tDBOutput_5 main ] stop
								 */

								/**
								 * [tDBOutput_5 process_data_begin ] start
								 */

								currentComponent = "tDBOutput_5";

								/**
								 * [tDBOutput_5 process_data_begin ] stop
								 */

								/**
								 * [tDBOutput_5 process_data_end ] start
								 */

								currentComponent = "tDBOutput_5";

								/**
								 * [tDBOutput_5 process_data_end ] stop
								 */

							} // End of branch "copyOfcopyOfduplicated"

// Start of branch "copyOfprimaryFail"
							if (copyOfprimaryFail != null) {

								/**
								 * [tFileOutputDelimited_4 main ] start
								 */

								currentComponent = "tFileOutputDelimited_4";

								if (execStat) {
									runStat.updateStatOnConnection(iterateId, 1, 1

											, "copyOfprimaryFail"

									);
								}

								StringBuilder sb_tFileOutputDelimited_4 = new StringBuilder();
								if (copyOfprimaryFail.CodeCIS != null) {
									sb_tFileOutputDelimited_4.append(copyOfprimaryFail.CodeCIS);
								}
								sb_tFileOutputDelimited_4.append(OUT_DELIM_ROWSEP_tFileOutputDelimited_4);

								nb_line_tFileOutputDelimited_4++;
								resourceMap.put("nb_line_tFileOutputDelimited_4", nb_line_tFileOutputDelimited_4);

								outtFileOutputDelimited_4.write(sb_tFileOutputDelimited_4.toString());

								tos_count_tFileOutputDelimited_4++;

								/**
								 * [tFileOutputDelimited_4 main ] stop
								 */

								/**
								 * [tFileOutputDelimited_4 process_data_begin ] start
								 */

								currentComponent = "tFileOutputDelimited_4";

								/**
								 * [tFileOutputDelimited_4 process_data_begin ] stop
								 */

								/**
								 * [tFileOutputDelimited_4 process_data_end ] start
								 */

								currentComponent = "tFileOutputDelimited_4";

								/**
								 * [tFileOutputDelimited_4 process_data_end ] stop
								 */

							} // End of branch "copyOfprimaryFail"

							/**
							 * [tMap_5 process_data_end ] start
							 */

							currentComponent = "tMap_5";

							/**
							 * [tMap_5 process_data_end ] stop
							 */

						} // End of branch "row8"

						/**
						 * [tFileInputDelimited_5 process_data_end ] start
						 */

						currentComponent = "tFileInputDelimited_5";

						/**
						 * [tFileInputDelimited_5 process_data_end ] stop
						 */

						/**
						 * [tFileInputDelimited_5 end ] start
						 */

						currentComponent = "tFileInputDelimited_5";

					}
				} finally {
					if (!((Object) ("C:/Users/Ethan/Documents/workspace/GROMED/data/fichiers/CIS_GENER_bdpm.txt") instanceof java.io.InputStream)) {
						if (fid_tFileInputDelimited_5 != null) {
							fid_tFileInputDelimited_5.close();
						}
					}
					if (fid_tFileInputDelimited_5 != null) {
						globalMap.put("tFileInputDelimited_5_NB_LINE", fid_tFileInputDelimited_5.getRowNumber());

					}
				}

				ok_Hash.put("tFileInputDelimited_5", true);
				end_Hash.put("tFileInputDelimited_5", System.currentTimeMillis());

				/**
				 * [tFileInputDelimited_5 end ] stop
				 */

				/**
				 * [tMap_5 end ] start
				 */

				currentComponent = "tMap_5";

// ###############################
// # Lookup hashes releasing
				if (tHash_Lookup_row9 != null) {
					tHash_Lookup_row9.endGet();
				}
				globalMap.remove("tHash_Lookup_row9");

// ###############################      

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row8");
				}

				ok_Hash.put("tMap_5", true);
				end_Hash.put("tMap_5", System.currentTimeMillis());

				/**
				 * [tMap_5 end ] stop
				 */

				/**
				 * [tDBOutput_5 end ] start
				 */

				currentComponent = "tDBOutput_5";

				try {
					if (batchSizeCounter_tDBOutput_5 != 0) {
						int countSum_tDBOutput_5 = 0;

						for (int countEach_tDBOutput_5 : pstmt_tDBOutput_5.executeBatch()) {
							countSum_tDBOutput_5 += (countEach_tDBOutput_5 == java.sql.Statement.EXECUTE_FAILED ? 0
									: 1);
						}
						rowsToCommitCount_tDBOutput_5 += countSum_tDBOutput_5;

						insertedCount_tDBOutput_5 += countSum_tDBOutput_5;

					}

				} catch (java.sql.BatchUpdateException e) {
					globalMap.put(currentComponent + "_ERROR_MESSAGE", e.getMessage());

					int countSum_tDBOutput_5 = 0;
					for (int countEach_tDBOutput_5 : e.getUpdateCounts()) {
						countSum_tDBOutput_5 += (countEach_tDBOutput_5 < 0 ? 0 : countEach_tDBOutput_5);
					}
					rowsToCommitCount_tDBOutput_5 += countSum_tDBOutput_5;

					insertedCount_tDBOutput_5 += countSum_tDBOutput_5;

					System.err.println(e.getMessage());

				}
				batchSizeCounter_tDBOutput_5 = 0;

				if (pstmt_tDBOutput_5 != null) {

					pstmt_tDBOutput_5.close();
					resourceMap.remove("pstmt_tDBOutput_5");

				}
				resourceMap.put("statementClosed_tDBOutput_5", true);
				if (commitCounter_tDBOutput_5 > 0 && rowsToCommitCount_tDBOutput_5 != 0) {

				}
				conn_tDBOutput_5.commit();
				if (commitCounter_tDBOutput_5 > 0 && rowsToCommitCount_tDBOutput_5 != 0) {

					rowsToCommitCount_tDBOutput_5 = 0;
				}
				commitCounter_tDBOutput_5 = 0;

				conn_tDBOutput_5.close();

				resourceMap.put("finish_tDBOutput_5", true);

				nb_line_deleted_tDBOutput_5 = nb_line_deleted_tDBOutput_5 + deletedCount_tDBOutput_5;
				nb_line_update_tDBOutput_5 = nb_line_update_tDBOutput_5 + updatedCount_tDBOutput_5;
				nb_line_inserted_tDBOutput_5 = nb_line_inserted_tDBOutput_5 + insertedCount_tDBOutput_5;
				nb_line_rejected_tDBOutput_5 = nb_line_rejected_tDBOutput_5 + rejectedCount_tDBOutput_5;

				globalMap.put("tDBOutput_5_NB_LINE", nb_line_tDBOutput_5);
				globalMap.put("tDBOutput_5_NB_LINE_UPDATED", nb_line_update_tDBOutput_5);
				globalMap.put("tDBOutput_5_NB_LINE_INSERTED", nb_line_inserted_tDBOutput_5);
				globalMap.put("tDBOutput_5_NB_LINE_DELETED", nb_line_deleted_tDBOutput_5);
				globalMap.put("tDBOutput_5_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_5);

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "copyOfcopyOfduplicated");
				}

				ok_Hash.put("tDBOutput_5", true);
				end_Hash.put("tDBOutput_5", System.currentTimeMillis());

				/**
				 * [tDBOutput_5 end ] stop
				 */

				/**
				 * [tFileOutputDelimited_4 end ] start
				 */

				currentComponent = "tFileOutputDelimited_4";

				if (outtFileOutputDelimited_4 != null) {
					outtFileOutputDelimited_4.flush();
					outtFileOutputDelimited_4.close();
				}

				globalMap.put("tFileOutputDelimited_4_NB_LINE", nb_line_tFileOutputDelimited_4);
				globalMap.put("tFileOutputDelimited_4_FILE_NAME", fileName_tFileOutputDelimited_4);

				resourceMap.put("finish_tFileOutputDelimited_4", true);

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "copyOfprimaryFail");
				}

				ok_Hash.put("tFileOutputDelimited_4", true);
				end_Hash.put("tFileOutputDelimited_4", System.currentTimeMillis());

				/**
				 * [tFileOutputDelimited_4 end ] stop
				 */

			} // end the resume

			if (resumeEntryMethodName == null || globalResumeTicket) {
				resumeUtil.addLog("CHECKPOINT", "CONNECTION:SUBJOB_OK:tFileInputDelimited_5:OnSubjobOk", "",
						Thread.currentThread().getId() + "", "", "", "", "", "");
			}

			if (execStat) {
				runStat.updateStatOnConnection("OnSubjobOk5", 0, "ok");
			}

			tFileInputDelimited_6Process(globalMap);

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			// free memory for "tMap_5"
			globalMap.remove("tHash_Lookup_row9");

			try {

				/**
				 * [tFileInputDelimited_5 finally ] start
				 */

				currentComponent = "tFileInputDelimited_5";

				/**
				 * [tFileInputDelimited_5 finally ] stop
				 */

				/**
				 * [tMap_5 finally ] start
				 */

				currentComponent = "tMap_5";

				/**
				 * [tMap_5 finally ] stop
				 */

				/**
				 * [tDBOutput_5 finally ] start
				 */

				currentComponent = "tDBOutput_5";

				try {
					if (resourceMap.get("statementClosed_tDBOutput_5") == null) {
						java.sql.PreparedStatement pstmtToClose_tDBOutput_5 = null;
						if ((pstmtToClose_tDBOutput_5 = (java.sql.PreparedStatement) resourceMap
								.remove("pstmt_tDBOutput_5")) != null) {
							pstmtToClose_tDBOutput_5.close();
						}
					}
				} finally {
					if (resourceMap.get("finish_tDBOutput_5") == null) {
						java.sql.Connection ctn_tDBOutput_5 = null;
						if ((ctn_tDBOutput_5 = (java.sql.Connection) resourceMap.get("conn_tDBOutput_5")) != null) {
							try {
								ctn_tDBOutput_5.close();
							} catch (java.sql.SQLException sqlEx_tDBOutput_5) {
								String errorMessage_tDBOutput_5 = "failed to close the connection in tDBOutput_5 :"
										+ sqlEx_tDBOutput_5.getMessage();
								System.err.println(errorMessage_tDBOutput_5);
							}
						}
					}
				}

				/**
				 * [tDBOutput_5 finally ] stop
				 */

				/**
				 * [tFileOutputDelimited_4 finally ] start
				 */

				currentComponent = "tFileOutputDelimited_4";

				if (resourceMap.get("finish_tFileOutputDelimited_4") == null) {

					java.io.Writer outtFileOutputDelimited_4 = (java.io.Writer) resourceMap
							.get("out_tFileOutputDelimited_4");
					if (outtFileOutputDelimited_4 != null) {
						outtFileOutputDelimited_4.flush();
						outtFileOutputDelimited_4.close();
					}

				}

				/**
				 * [tFileOutputDelimited_4 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tFileInputDelimited_5_SUBPROCESS_STATE", 1);
	}

	public static class copyOfcopyOfcopyOfduplicatedStruct
			implements routines.system.IPersistableRow<copyOfcopyOfcopyOfduplicatedStruct> {
		final static byte[] commonByteArrayLock_GROMED_dump_gros_med_brut = new byte[0];
		static byte[] commonByteArray_GROMED_dump_gros_med_brut = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public int id;

		public int getId() {
			return this.id;
		}

		public String codeCIS;

		public String getCodeCIS() {
			return this.codeCIS;
		}

		public String dateDebutInfoSecurite;

		public String getDateDebutInfoSecurite() {
			return this.dateDebutInfoSecurite;
		}

		public String dateFinInfoSecurite;

		public String getDateFinInfoSecurite() {
			return this.dateFinInfoSecurite;
		}

		public String infoSecurite;

		public String getInfoSecurite() {
			return this.infoSecurite;
		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + (int) this.id;

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final copyOfcopyOfcopyOfduplicatedStruct other = (copyOfcopyOfcopyOfduplicatedStruct) obj;

			if (this.id != other.id)
				return false;

			return true;
		}

		public void copyDataTo(copyOfcopyOfcopyOfduplicatedStruct other) {

			other.id = this.id;
			other.codeCIS = this.codeCIS;
			other.dateDebutInfoSecurite = this.dateDebutInfoSecurite;
			other.dateFinInfoSecurite = this.dateFinInfoSecurite;
			other.infoSecurite = this.infoSecurite;

		}

		public void copyKeysDataTo(copyOfcopyOfcopyOfduplicatedStruct other) {

			other.id = this.id;

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_GROMED_dump_gros_med_brut.length) {
					if (length < 1024 && commonByteArray_GROMED_dump_gros_med_brut.length == 0) {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[1024];
					} else {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_GROMED_dump_gros_med_brut, 0, length);
				strReturn = new String(commonByteArray_GROMED_dump_gros_med_brut, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_GROMED_dump_gros_med_brut.length) {
					if (length < 1024 && commonByteArray_GROMED_dump_gros_med_brut.length == 0) {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[1024];
					} else {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_GROMED_dump_gros_med_brut, 0, length);
				strReturn = new String(commonByteArray_GROMED_dump_gros_med_brut, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_GROMED_dump_gros_med_brut) {

				try {

					int length = 0;

					this.id = dis.readInt();

					this.codeCIS = readString(dis);

					this.dateDebutInfoSecurite = readString(dis);

					this.dateFinInfoSecurite = readString(dis);

					this.infoSecurite = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_GROMED_dump_gros_med_brut) {

				try {

					int length = 0;

					this.id = dis.readInt();

					this.codeCIS = readString(dis);

					this.dateDebutInfoSecurite = readString(dis);

					this.dateFinInfoSecurite = readString(dis);

					this.infoSecurite = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// int

				dos.writeInt(this.id);

				// String

				writeString(this.codeCIS, dos);

				// String

				writeString(this.dateDebutInfoSecurite, dos);

				// String

				writeString(this.dateFinInfoSecurite, dos);

				// String

				writeString(this.infoSecurite, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// int

				dos.writeInt(this.id);

				// String

				writeString(this.codeCIS, dos);

				// String

				writeString(this.dateDebutInfoSecurite, dos);

				// String

				writeString(this.dateFinInfoSecurite, dos);

				// String

				writeString(this.infoSecurite, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("id=" + String.valueOf(id));
			sb.append(",codeCIS=" + codeCIS);
			sb.append(",dateDebutInfoSecurite=" + dateDebutInfoSecurite);
			sb.append(",dateFinInfoSecurite=" + dateFinInfoSecurite);
			sb.append(",infoSecurite=" + infoSecurite);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(copyOfcopyOfcopyOfduplicatedStruct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.id, other.id);
			if (returnValue != 0) {
				return returnValue;
			}

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class copyOfcopyOfprimaryFailStruct
			implements routines.system.IPersistableRow<copyOfcopyOfprimaryFailStruct> {
		final static byte[] commonByteArrayLock_GROMED_dump_gros_med_brut = new byte[0];
		static byte[] commonByteArray_GROMED_dump_gros_med_brut = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public String CodeCIS;

		public String getCodeCIS() {
			return this.CodeCIS;
		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + ((this.CodeCIS == null) ? 0 : this.CodeCIS.hashCode());

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final copyOfcopyOfprimaryFailStruct other = (copyOfcopyOfprimaryFailStruct) obj;

			if (this.CodeCIS == null) {
				if (other.CodeCIS != null)
					return false;

			} else if (!this.CodeCIS.equals(other.CodeCIS))

				return false;

			return true;
		}

		public void copyDataTo(copyOfcopyOfprimaryFailStruct other) {

			other.CodeCIS = this.CodeCIS;

		}

		public void copyKeysDataTo(copyOfcopyOfprimaryFailStruct other) {

			other.CodeCIS = this.CodeCIS;

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_GROMED_dump_gros_med_brut.length) {
					if (length < 1024 && commonByteArray_GROMED_dump_gros_med_brut.length == 0) {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[1024];
					} else {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_GROMED_dump_gros_med_brut, 0, length);
				strReturn = new String(commonByteArray_GROMED_dump_gros_med_brut, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_GROMED_dump_gros_med_brut.length) {
					if (length < 1024 && commonByteArray_GROMED_dump_gros_med_brut.length == 0) {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[1024];
					} else {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_GROMED_dump_gros_med_brut, 0, length);
				strReturn = new String(commonByteArray_GROMED_dump_gros_med_brut, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_GROMED_dump_gros_med_brut) {

				try {

					int length = 0;

					this.CodeCIS = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_GROMED_dump_gros_med_brut) {

				try {

					int length = 0;

					this.CodeCIS = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.CodeCIS, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.CodeCIS, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("CodeCIS=" + CodeCIS);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(copyOfcopyOfprimaryFailStruct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.CodeCIS, other.CodeCIS);
			if (returnValue != 0) {
				return returnValue;
			}

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class row10Struct implements routines.system.IPersistableRow<row10Struct> {
		final static byte[] commonByteArrayLock_GROMED_dump_gros_med_brut = new byte[0];
		static byte[] commonByteArray_GROMED_dump_gros_med_brut = new byte[0];

		public String codeCIS;

		public String getCodeCIS() {
			return this.codeCIS;
		}

		public String dateDeb;

		public String getDateDeb() {
			return this.dateDeb;
		}

		public String dateFin;

		public String getDateFin() {
			return this.dateFin;
		}

		public String texte;

		public String getTexte() {
			return this.texte;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_GROMED_dump_gros_med_brut.length) {
					if (length < 1024 && commonByteArray_GROMED_dump_gros_med_brut.length == 0) {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[1024];
					} else {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_GROMED_dump_gros_med_brut, 0, length);
				strReturn = new String(commonByteArray_GROMED_dump_gros_med_brut, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_GROMED_dump_gros_med_brut.length) {
					if (length < 1024 && commonByteArray_GROMED_dump_gros_med_brut.length == 0) {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[1024];
					} else {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_GROMED_dump_gros_med_brut, 0, length);
				strReturn = new String(commonByteArray_GROMED_dump_gros_med_brut, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_GROMED_dump_gros_med_brut) {

				try {

					int length = 0;

					this.codeCIS = readString(dis);

					this.dateDeb = readString(dis);

					this.dateFin = readString(dis);

					this.texte = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_GROMED_dump_gros_med_brut) {

				try {

					int length = 0;

					this.codeCIS = readString(dis);

					this.dateDeb = readString(dis);

					this.dateFin = readString(dis);

					this.texte = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.codeCIS, dos);

				// String

				writeString(this.dateDeb, dos);

				// String

				writeString(this.dateFin, dos);

				// String

				writeString(this.texte, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.codeCIS, dos);

				// String

				writeString(this.dateDeb, dos);

				// String

				writeString(this.dateFin, dos);

				// String

				writeString(this.texte, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("codeCIS=" + codeCIS);
			sb.append(",dateDeb=" + dateDeb);
			sb.append(",dateFin=" + dateFin);
			sb.append(",texte=" + texte);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row10Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class after_tFileInputDelimited_6Struct
			implements routines.system.IPersistableRow<after_tFileInputDelimited_6Struct> {
		final static byte[] commonByteArrayLock_GROMED_dump_gros_med_brut = new byte[0];
		static byte[] commonByteArray_GROMED_dump_gros_med_brut = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public String codeCIS;

		public String getCodeCIS() {
			return this.codeCIS;
		}

		public String dateDeb;

		public String getDateDeb() {
			return this.dateDeb;
		}

		public String dateFin;

		public String getDateFin() {
			return this.dateFin;
		}

		public String texte;

		public String getTexte() {
			return this.texte;
		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + ((this.codeCIS == null) ? 0 : this.codeCIS.hashCode());

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final after_tFileInputDelimited_6Struct other = (after_tFileInputDelimited_6Struct) obj;

			if (this.codeCIS == null) {
				if (other.codeCIS != null)
					return false;

			} else if (!this.codeCIS.equals(other.codeCIS))

				return false;

			return true;
		}

		public void copyDataTo(after_tFileInputDelimited_6Struct other) {

			other.codeCIS = this.codeCIS;
			other.dateDeb = this.dateDeb;
			other.dateFin = this.dateFin;
			other.texte = this.texte;

		}

		public void copyKeysDataTo(after_tFileInputDelimited_6Struct other) {

			other.codeCIS = this.codeCIS;

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_GROMED_dump_gros_med_brut.length) {
					if (length < 1024 && commonByteArray_GROMED_dump_gros_med_brut.length == 0) {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[1024];
					} else {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_GROMED_dump_gros_med_brut, 0, length);
				strReturn = new String(commonByteArray_GROMED_dump_gros_med_brut, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_GROMED_dump_gros_med_brut.length) {
					if (length < 1024 && commonByteArray_GROMED_dump_gros_med_brut.length == 0) {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[1024];
					} else {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_GROMED_dump_gros_med_brut, 0, length);
				strReturn = new String(commonByteArray_GROMED_dump_gros_med_brut, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_GROMED_dump_gros_med_brut) {

				try {

					int length = 0;

					this.codeCIS = readString(dis);

					this.dateDeb = readString(dis);

					this.dateFin = readString(dis);

					this.texte = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_GROMED_dump_gros_med_brut) {

				try {

					int length = 0;

					this.codeCIS = readString(dis);

					this.dateDeb = readString(dis);

					this.dateFin = readString(dis);

					this.texte = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.codeCIS, dos);

				// String

				writeString(this.dateDeb, dos);

				// String

				writeString(this.dateFin, dos);

				// String

				writeString(this.texte, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.codeCIS, dos);

				// String

				writeString(this.dateDeb, dos);

				// String

				writeString(this.dateFin, dos);

				// String

				writeString(this.texte, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("codeCIS=" + codeCIS);
			sb.append(",dateDeb=" + dateDeb);
			sb.append(",dateFin=" + dateFin);
			sb.append(",texte=" + texte);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(after_tFileInputDelimited_6Struct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.codeCIS, other.codeCIS);
			if (returnValue != 0) {
				return returnValue;
			}

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public void tFileInputDelimited_6Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tFileInputDelimited_6_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				tDBInput_5Process(globalMap);

				row10Struct row10 = new row10Struct();
				copyOfcopyOfcopyOfduplicatedStruct copyOfcopyOfcopyOfduplicated = new copyOfcopyOfcopyOfduplicatedStruct();
				copyOfcopyOfprimaryFailStruct copyOfcopyOfprimaryFail = new copyOfcopyOfprimaryFailStruct();

				/**
				 * [tDBOutput_6 begin ] start
				 */

				ok_Hash.put("tDBOutput_6", false);
				start_Hash.put("tDBOutput_6", System.currentTimeMillis());

				currentComponent = "tDBOutput_6";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "copyOfcopyOfcopyOfduplicated");
				}

				int tos_count_tDBOutput_6 = 0;

				int nb_line_tDBOutput_6 = 0;
				int nb_line_update_tDBOutput_6 = 0;
				int nb_line_inserted_tDBOutput_6 = 0;
				int nb_line_deleted_tDBOutput_6 = 0;
				int nb_line_rejected_tDBOutput_6 = 0;

				int deletedCount_tDBOutput_6 = 0;
				int updatedCount_tDBOutput_6 = 0;
				int insertedCount_tDBOutput_6 = 0;
				int rowsToCommitCount_tDBOutput_6 = 0;
				int rejectedCount_tDBOutput_6 = 0;

				String tableName_tDBOutput_6 = "cis_info_importantes";
				boolean whetherReject_tDBOutput_6 = false;

				java.util.Calendar calendar_tDBOutput_6 = java.util.Calendar.getInstance();
				calendar_tDBOutput_6.set(1, 0, 1, 0, 0, 0);
				long year1_tDBOutput_6 = calendar_tDBOutput_6.getTime().getTime();
				calendar_tDBOutput_6.set(10000, 0, 1, 0, 0, 0);
				long year10000_tDBOutput_6 = calendar_tDBOutput_6.getTime().getTime();
				long date_tDBOutput_6;

				java.sql.Connection conn_tDBOutput_6 = null;

				String properties_tDBOutput_6 = context.gros_med_brut1_AdditionalParams;
				if (properties_tDBOutput_6 == null || properties_tDBOutput_6.trim().length() == 0) {
					properties_tDBOutput_6 = "rewriteBatchedStatements=true&allowLoadLocalInfile=true";
				} else {
					if (!properties_tDBOutput_6.contains("rewriteBatchedStatements=")) {
						properties_tDBOutput_6 += "&rewriteBatchedStatements=true";
					}

					if (!properties_tDBOutput_6.contains("allowLoadLocalInfile=")) {
						properties_tDBOutput_6 += "&allowLoadLocalInfile=true";
					}
				}

				String url_tDBOutput_6 = "jdbc:mariadb://" + context.gros_med_brut1_Server + ":"
						+ context.gros_med_brut1_Port + "/" + context.gros_med_brut1_Database + "?"
						+ properties_tDBOutput_6;

				String driverClass_tDBOutput_6 = "org.mariadb.jdbc.Driver";

				String dbUser_tDBOutput_6 = context.gros_med_brut1_Login;

				final String decryptedPassword_tDBOutput_6 = context.gros_med_brut1_Password;

				String dbPwd_tDBOutput_6 = decryptedPassword_tDBOutput_6;
				java.lang.Class.forName(driverClass_tDBOutput_6);

				conn_tDBOutput_6 = java.sql.DriverManager.getConnection(url_tDBOutput_6, dbUser_tDBOutput_6,
						dbPwd_tDBOutput_6);

				resourceMap.put("conn_tDBOutput_6", conn_tDBOutput_6);
				conn_tDBOutput_6.setAutoCommit(false);
				int commitEvery_tDBOutput_6 = 10000;
				int commitCounter_tDBOutput_6 = 0;

				int count_tDBOutput_6 = 0;

				try (java.sql.Statement stmtClear_tDBOutput_6 = conn_tDBOutput_6.createStatement()) {
					stmtClear_tDBOutput_6.executeUpdate("DELETE FROM `" + tableName_tDBOutput_6 + "`");
				}

				String insert_tDBOutput_6 = "INSERT INTO `" + "cis_info_importantes"
						+ "` (`id`,`codeCIS`,`dateDebutInfoSecurite`,`dateFinInfoSecurite`,`infoSecurite`) VALUES (?,?,?,?,?)";
				int batchSize_tDBOutput_6 = 100;
				int batchSizeCounter_tDBOutput_6 = 0;

				java.sql.PreparedStatement pstmt_tDBOutput_6 = conn_tDBOutput_6.prepareStatement(insert_tDBOutput_6);
				resourceMap.put("pstmt_tDBOutput_6", pstmt_tDBOutput_6);

				/**
				 * [tDBOutput_6 begin ] stop
				 */

				/**
				 * [tFileOutputDelimited_5 begin ] start
				 */

				ok_Hash.put("tFileOutputDelimited_5", false);
				start_Hash.put("tFileOutputDelimited_5", System.currentTimeMillis());

				currentComponent = "tFileOutputDelimited_5";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "copyOfcopyOfprimaryFail");
				}

				int tos_count_tFileOutputDelimited_5 = 0;

				String fileName_tFileOutputDelimited_5 = "";
				fileName_tFileOutputDelimited_5 = (new java.io.File(
						context.source + "log/cis_info_secu_bdpm_Unknow_Primarykey.log")).getAbsolutePath()
								.replace("\\", "/");
				String fullName_tFileOutputDelimited_5 = null;
				String extension_tFileOutputDelimited_5 = null;
				String directory_tFileOutputDelimited_5 = null;
				if ((fileName_tFileOutputDelimited_5.indexOf("/") != -1)) {
					if (fileName_tFileOutputDelimited_5.lastIndexOf(".") < fileName_tFileOutputDelimited_5
							.lastIndexOf("/")) {
						fullName_tFileOutputDelimited_5 = fileName_tFileOutputDelimited_5;
						extension_tFileOutputDelimited_5 = "";
					} else {
						fullName_tFileOutputDelimited_5 = fileName_tFileOutputDelimited_5.substring(0,
								fileName_tFileOutputDelimited_5.lastIndexOf("."));
						extension_tFileOutputDelimited_5 = fileName_tFileOutputDelimited_5
								.substring(fileName_tFileOutputDelimited_5.lastIndexOf("."));
					}
					directory_tFileOutputDelimited_5 = fileName_tFileOutputDelimited_5.substring(0,
							fileName_tFileOutputDelimited_5.lastIndexOf("/"));
				} else {
					if (fileName_tFileOutputDelimited_5.lastIndexOf(".") != -1) {
						fullName_tFileOutputDelimited_5 = fileName_tFileOutputDelimited_5.substring(0,
								fileName_tFileOutputDelimited_5.lastIndexOf("."));
						extension_tFileOutputDelimited_5 = fileName_tFileOutputDelimited_5
								.substring(fileName_tFileOutputDelimited_5.lastIndexOf("."));
					} else {
						fullName_tFileOutputDelimited_5 = fileName_tFileOutputDelimited_5;
						extension_tFileOutputDelimited_5 = "";
					}
					directory_tFileOutputDelimited_5 = "";
				}
				boolean isFileGenerated_tFileOutputDelimited_5 = true;
				java.io.File filetFileOutputDelimited_5 = new java.io.File(fileName_tFileOutputDelimited_5);
				globalMap.put("tFileOutputDelimited_5_FILE_NAME", fileName_tFileOutputDelimited_5);
				int nb_line_tFileOutputDelimited_5 = 0;
				int splitedFileNo_tFileOutputDelimited_5 = 0;
				int currentRow_tFileOutputDelimited_5 = 0;

				final String OUT_DELIM_tFileOutputDelimited_5 = /** Start field tFileOutputDelimited_5:FIELDSEPARATOR */
						";"/** End field tFileOutputDelimited_5:FIELDSEPARATOR */
				;

				final String OUT_DELIM_ROWSEP_tFileOutputDelimited_5 = /**
																		 * Start field
																		 * tFileOutputDelimited_5:ROWSEPARATOR
																		 */
						"\n"/** End field tFileOutputDelimited_5:ROWSEPARATOR */
				;

				// create directory only if not exists
				if (directory_tFileOutputDelimited_5 != null && directory_tFileOutputDelimited_5.trim().length() != 0) {
					java.io.File dir_tFileOutputDelimited_5 = new java.io.File(directory_tFileOutputDelimited_5);
					if (!dir_tFileOutputDelimited_5.exists()) {
						dir_tFileOutputDelimited_5.mkdirs();
					}
				}

				// routines.system.Row
				java.io.Writer outtFileOutputDelimited_5 = null;

				java.io.File fileToDelete_tFileOutputDelimited_5 = new java.io.File(fileName_tFileOutputDelimited_5);
				if (fileToDelete_tFileOutputDelimited_5.exists()) {
					fileToDelete_tFileOutputDelimited_5.delete();
				}
				outtFileOutputDelimited_5 = new java.io.BufferedWriter(new java.io.OutputStreamWriter(
						new java.io.FileOutputStream(fileName_tFileOutputDelimited_5, false), "ISO-8859-15"));

				resourceMap.put("out_tFileOutputDelimited_5", outtFileOutputDelimited_5);
				resourceMap.put("nb_line_tFileOutputDelimited_5", nb_line_tFileOutputDelimited_5);

				/**
				 * [tFileOutputDelimited_5 begin ] stop
				 */

				/**
				 * [tMap_6 begin ] start
				 */

				ok_Hash.put("tMap_6", false);
				start_Hash.put("tMap_6", System.currentTimeMillis());

				currentComponent = "tMap_6";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row10");
				}

				int tos_count_tMap_6 = 0;

// ###############################
// # Lookup's keys initialization

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row11Struct> tHash_Lookup_row11 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row11Struct>) ((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row11Struct>) globalMap
						.get("tHash_Lookup_row11"));

				row11Struct row11HashKey = new row11Struct();
				row11Struct row11Default = new row11Struct();
// ###############################        

// ###############################
// # Vars initialization
				class Var__tMap_6__Struct {
				}
				Var__tMap_6__Struct Var__tMap_6 = new Var__tMap_6__Struct();
// ###############################

// ###############################
// # Outputs initialization
				copyOfcopyOfcopyOfduplicatedStruct copyOfcopyOfcopyOfduplicated_tmp = new copyOfcopyOfcopyOfduplicatedStruct();
				copyOfcopyOfprimaryFailStruct copyOfcopyOfprimaryFail_tmp = new copyOfcopyOfprimaryFailStruct();
// ###############################

				/**
				 * [tMap_6 begin ] stop
				 */

				/**
				 * [tFileInputDelimited_6 begin ] start
				 */

				ok_Hash.put("tFileInputDelimited_6", false);
				start_Hash.put("tFileInputDelimited_6", System.currentTimeMillis());

				currentComponent = "tFileInputDelimited_6";

				int tos_count_tFileInputDelimited_6 = 0;

				final routines.system.RowState rowstate_tFileInputDelimited_6 = new routines.system.RowState();

				int nb_line_tFileInputDelimited_6 = 0;
				org.talend.fileprocess.FileInputDelimited fid_tFileInputDelimited_6 = null;
				int limit_tFileInputDelimited_6 = -1;
				try {

					Object filename_tFileInputDelimited_6 = "C:/Users/Ethan/Documents/workspace/GROMED/data/fichiers/CIS_InfoImportantes_20221019150103_bdpm.txt";
					if (filename_tFileInputDelimited_6 instanceof java.io.InputStream) {

						int footer_value_tFileInputDelimited_6 = 0, random_value_tFileInputDelimited_6 = -1;
						if (footer_value_tFileInputDelimited_6 > 0 || random_value_tFileInputDelimited_6 > 0) {
							throw new java.lang.Exception(
									"When the input source is a stream,footer and random shouldn't be bigger than 0.");
						}

					}
					try {
						fid_tFileInputDelimited_6 = new org.talend.fileprocess.FileInputDelimited(
								"C:/Users/Ethan/Documents/workspace/GROMED/data/fichiers/CIS_InfoImportantes_20221019150103_bdpm.txt",
								"ISO-8859-15", "\t", "\n", false, 0, 0, limit_tFileInputDelimited_6, -1, false);
					} catch (java.lang.Exception e) {
						globalMap.put("tFileInputDelimited_6_ERROR_MESSAGE", e.getMessage());

						System.err.println(e.getMessage());

					}

					while (fid_tFileInputDelimited_6 != null && fid_tFileInputDelimited_6.nextRecord()) {
						rowstate_tFileInputDelimited_6.reset();

						row10 = null;

						boolean whetherReject_tFileInputDelimited_6 = false;
						row10 = new row10Struct();
						try {

							int columnIndexWithD_tFileInputDelimited_6 = 0;

							columnIndexWithD_tFileInputDelimited_6 = 0;

							row10.codeCIS = fid_tFileInputDelimited_6.get(columnIndexWithD_tFileInputDelimited_6);

							columnIndexWithD_tFileInputDelimited_6 = 1;

							row10.dateDeb = fid_tFileInputDelimited_6.get(columnIndexWithD_tFileInputDelimited_6);

							columnIndexWithD_tFileInputDelimited_6 = 2;

							row10.dateFin = fid_tFileInputDelimited_6.get(columnIndexWithD_tFileInputDelimited_6);

							columnIndexWithD_tFileInputDelimited_6 = 3;

							row10.texte = fid_tFileInputDelimited_6.get(columnIndexWithD_tFileInputDelimited_6);

							if (rowstate_tFileInputDelimited_6.getException() != null) {
								throw rowstate_tFileInputDelimited_6.getException();
							}

						} catch (java.lang.Exception e) {
							globalMap.put("tFileInputDelimited_6_ERROR_MESSAGE", e.getMessage());
							whetherReject_tFileInputDelimited_6 = true;

							System.err.println(e.getMessage());
							row10 = null;

						}

						/**
						 * [tFileInputDelimited_6 begin ] stop
						 */

						/**
						 * [tFileInputDelimited_6 main ] start
						 */

						currentComponent = "tFileInputDelimited_6";

						tos_count_tFileInputDelimited_6++;

						/**
						 * [tFileInputDelimited_6 main ] stop
						 */

						/**
						 * [tFileInputDelimited_6 process_data_begin ] start
						 */

						currentComponent = "tFileInputDelimited_6";

						/**
						 * [tFileInputDelimited_6 process_data_begin ] stop
						 */
// Start of branch "row10"
						if (row10 != null) {

							/**
							 * [tMap_6 main ] start
							 */

							currentComponent = "tMap_6";

							if (execStat) {
								runStat.updateStatOnConnection(iterateId, 1, 1

										, "row10"

								);
							}

							boolean hasCasePrimitiveKeyWithNull_tMap_6 = false;

							// ###############################
							// # Input tables (lookups)
							boolean rejectedInnerJoin_tMap_6 = false;
							boolean mainRowRejected_tMap_6 = false;

							///////////////////////////////////////////////
							// Starting Lookup Table "row11"
							///////////////////////////////////////////////

							boolean forceLooprow11 = false;

							row11Struct row11ObjectFromLookup = null;

							if (!rejectedInnerJoin_tMap_6) { // G_TM_M_020

								hasCasePrimitiveKeyWithNull_tMap_6 = false;

								row11HashKey.codeCIS = row10.codeCIS;

								row11HashKey.hashCodeDirty = true;

								tHash_Lookup_row11.lookup(row11HashKey);

								if (!tHash_Lookup_row11.hasNext()) { // G_TM_M_090

									rejectedInnerJoin_tMap_6 = true;

								} // G_TM_M_090

							} // G_TM_M_020

							if (tHash_Lookup_row11 != null && tHash_Lookup_row11.getCount(row11HashKey) > 1) { // G 071

								// System.out.println("WARNING: UNIQUE MATCH is configured for the lookup
								// 'row11' and it contains more one result from keys : row11.codeCIS = '" +
								// row11HashKey.codeCIS + "'");
							} // G 071

							row11Struct row11 = null;

							row11Struct fromLookup_row11 = null;
							row11 = row11Default;

							if (tHash_Lookup_row11 != null && tHash_Lookup_row11.hasNext()) { // G 099

								fromLookup_row11 = tHash_Lookup_row11.next();

							} // G 099

							if (fromLookup_row11 != null) {
								row11 = fromLookup_row11;
							}

							// ###############################
							{ // start of Var scope

								// ###############################
								// # Vars tables

								Var__tMap_6__Struct Var = Var__tMap_6;// ###############################
								// ###############################
								// # Output tables

								copyOfcopyOfcopyOfduplicated = null;
								copyOfcopyOfprimaryFail = null;

								if (!rejectedInnerJoin_tMap_6) {

// # Output table : 'copyOfcopyOfcopyOfduplicated'
									copyOfcopyOfcopyOfduplicated_tmp.id = 0;
									copyOfcopyOfcopyOfduplicated_tmp.codeCIS = row10.codeCIS;
									copyOfcopyOfcopyOfduplicated_tmp.dateDebutInfoSecurite = row10.dateDeb;
									copyOfcopyOfcopyOfduplicated_tmp.dateFinInfoSecurite = row10.dateFin;
									copyOfcopyOfcopyOfduplicated_tmp.infoSecurite = row10.texte;
									copyOfcopyOfcopyOfduplicated = copyOfcopyOfcopyOfduplicated_tmp;
								} // closing inner join bracket (1)
// ###### START REJECTS ##### 

// # Output reject table : 'copyOfcopyOfprimaryFail'
// # Filter conditions 
								if (rejectedInnerJoin_tMap_6) {
									copyOfcopyOfprimaryFail_tmp.CodeCIS = row10.codeCIS;
									copyOfcopyOfprimaryFail = copyOfcopyOfprimaryFail_tmp;
								} // closing filter/reject
// ###############################

							} // end of Var scope

							rejectedInnerJoin_tMap_6 = false;

							tos_count_tMap_6++;

							/**
							 * [tMap_6 main ] stop
							 */

							/**
							 * [tMap_6 process_data_begin ] start
							 */

							currentComponent = "tMap_6";

							/**
							 * [tMap_6 process_data_begin ] stop
							 */
// Start of branch "copyOfcopyOfcopyOfduplicated"
							if (copyOfcopyOfcopyOfduplicated != null) {

								/**
								 * [tDBOutput_6 main ] start
								 */

								currentComponent = "tDBOutput_6";

								if (execStat) {
									runStat.updateStatOnConnection(iterateId, 1, 1

											, "copyOfcopyOfcopyOfduplicated"

									);
								}

								whetherReject_tDBOutput_6 = false;
								pstmt_tDBOutput_6.setInt(1, copyOfcopyOfcopyOfduplicated.id);

								if (copyOfcopyOfcopyOfduplicated.codeCIS == null) {
									pstmt_tDBOutput_6.setNull(2, java.sql.Types.VARCHAR);
								} else {
									pstmt_tDBOutput_6.setString(2, copyOfcopyOfcopyOfduplicated.codeCIS);
								}

								if (copyOfcopyOfcopyOfduplicated.dateDebutInfoSecurite == null) {
									pstmt_tDBOutput_6.setNull(3, java.sql.Types.VARCHAR);
								} else {
									pstmt_tDBOutput_6.setString(3, copyOfcopyOfcopyOfduplicated.dateDebutInfoSecurite);
								}

								if (copyOfcopyOfcopyOfduplicated.dateFinInfoSecurite == null) {
									pstmt_tDBOutput_6.setNull(4, java.sql.Types.VARCHAR);
								} else {
									pstmt_tDBOutput_6.setString(4, copyOfcopyOfcopyOfduplicated.dateFinInfoSecurite);
								}

								if (copyOfcopyOfcopyOfduplicated.infoSecurite == null) {
									pstmt_tDBOutput_6.setNull(5, java.sql.Types.VARCHAR);
								} else {
									pstmt_tDBOutput_6.setString(5, copyOfcopyOfcopyOfduplicated.infoSecurite);
								}

								pstmt_tDBOutput_6.addBatch();
								nb_line_tDBOutput_6++;

								batchSizeCounter_tDBOutput_6++;
								if (batchSize_tDBOutput_6 <= batchSizeCounter_tDBOutput_6) {
									try {
										int countSum_tDBOutput_6 = 0;
										for (int countEach_tDBOutput_6 : pstmt_tDBOutput_6.executeBatch()) {
											countSum_tDBOutput_6 += (countEach_tDBOutput_6 == java.sql.Statement.EXECUTE_FAILED
													? 0
													: 1);
										}
										rowsToCommitCount_tDBOutput_6 += countSum_tDBOutput_6;
										insertedCount_tDBOutput_6 += countSum_tDBOutput_6;
									} catch (java.sql.BatchUpdateException e) {
										globalMap.put("tDBOutput_6_ERROR_MESSAGE", e.getMessage());
										int countSum_tDBOutput_6 = 0;
										for (int countEach_tDBOutput_6 : e.getUpdateCounts()) {
											countSum_tDBOutput_6 += (countEach_tDBOutput_6 < 0 ? 0
													: countEach_tDBOutput_6);
										}
										rowsToCommitCount_tDBOutput_6 += countSum_tDBOutput_6;
										insertedCount_tDBOutput_6 += countSum_tDBOutput_6;
										System.err.println(e.getMessage());
									}

									batchSizeCounter_tDBOutput_6 = 0;
								}
								commitCounter_tDBOutput_6++;

								if (commitEvery_tDBOutput_6 <= commitCounter_tDBOutput_6) {

									try {
										int countSum_tDBOutput_6 = 0;
										for (int countEach_tDBOutput_6 : pstmt_tDBOutput_6.executeBatch()) {
											countSum_tDBOutput_6 += (countEach_tDBOutput_6 < 0 ? 0 : 1);
										}
										rowsToCommitCount_tDBOutput_6 += countSum_tDBOutput_6;
										insertedCount_tDBOutput_6 += countSum_tDBOutput_6;
									} catch (java.sql.BatchUpdateException e) {
										globalMap.put("tDBOutput_6_ERROR_MESSAGE", e.getMessage());
										int countSum_tDBOutput_6 = 0;
										for (int countEach_tDBOutput_6 : e.getUpdateCounts()) {
											countSum_tDBOutput_6 += (countEach_tDBOutput_6 < 0 ? 0
													: countEach_tDBOutput_6);
										}
										rowsToCommitCount_tDBOutput_6 += countSum_tDBOutput_6;
										insertedCount_tDBOutput_6 += countSum_tDBOutput_6;
										System.err.println(e.getMessage());

									}
									if (rowsToCommitCount_tDBOutput_6 != 0) {
									}
									conn_tDBOutput_6.commit();
									if (rowsToCommitCount_tDBOutput_6 != 0) {
										rowsToCommitCount_tDBOutput_6 = 0;
									}
									commitCounter_tDBOutput_6 = 0;

								}

								tos_count_tDBOutput_6++;

								/**
								 * [tDBOutput_6 main ] stop
								 */

								/**
								 * [tDBOutput_6 process_data_begin ] start
								 */

								currentComponent = "tDBOutput_6";

								/**
								 * [tDBOutput_6 process_data_begin ] stop
								 */

								/**
								 * [tDBOutput_6 process_data_end ] start
								 */

								currentComponent = "tDBOutput_6";

								/**
								 * [tDBOutput_6 process_data_end ] stop
								 */

							} // End of branch "copyOfcopyOfcopyOfduplicated"

// Start of branch "copyOfcopyOfprimaryFail"
							if (copyOfcopyOfprimaryFail != null) {

								/**
								 * [tFileOutputDelimited_5 main ] start
								 */

								currentComponent = "tFileOutputDelimited_5";

								if (execStat) {
									runStat.updateStatOnConnection(iterateId, 1, 1

											, "copyOfcopyOfprimaryFail"

									);
								}

								StringBuilder sb_tFileOutputDelimited_5 = new StringBuilder();
								if (copyOfcopyOfprimaryFail.CodeCIS != null) {
									sb_tFileOutputDelimited_5.append(copyOfcopyOfprimaryFail.CodeCIS);
								}
								sb_tFileOutputDelimited_5.append(OUT_DELIM_ROWSEP_tFileOutputDelimited_5);

								nb_line_tFileOutputDelimited_5++;
								resourceMap.put("nb_line_tFileOutputDelimited_5", nb_line_tFileOutputDelimited_5);

								outtFileOutputDelimited_5.write(sb_tFileOutputDelimited_5.toString());

								tos_count_tFileOutputDelimited_5++;

								/**
								 * [tFileOutputDelimited_5 main ] stop
								 */

								/**
								 * [tFileOutputDelimited_5 process_data_begin ] start
								 */

								currentComponent = "tFileOutputDelimited_5";

								/**
								 * [tFileOutputDelimited_5 process_data_begin ] stop
								 */

								/**
								 * [tFileOutputDelimited_5 process_data_end ] start
								 */

								currentComponent = "tFileOutputDelimited_5";

								/**
								 * [tFileOutputDelimited_5 process_data_end ] stop
								 */

							} // End of branch "copyOfcopyOfprimaryFail"

							/**
							 * [tMap_6 process_data_end ] start
							 */

							currentComponent = "tMap_6";

							/**
							 * [tMap_6 process_data_end ] stop
							 */

						} // End of branch "row10"

						/**
						 * [tFileInputDelimited_6 process_data_end ] start
						 */

						currentComponent = "tFileInputDelimited_6";

						/**
						 * [tFileInputDelimited_6 process_data_end ] stop
						 */

						/**
						 * [tFileInputDelimited_6 end ] start
						 */

						currentComponent = "tFileInputDelimited_6";

					}
				} finally {
					if (!((Object) ("C:/Users/Ethan/Documents/workspace/GROMED/data/fichiers/CIS_InfoImportantes_20221019150103_bdpm.txt") instanceof java.io.InputStream)) {
						if (fid_tFileInputDelimited_6 != null) {
							fid_tFileInputDelimited_6.close();
						}
					}
					if (fid_tFileInputDelimited_6 != null) {
						globalMap.put("tFileInputDelimited_6_NB_LINE", fid_tFileInputDelimited_6.getRowNumber());

					}
				}

				ok_Hash.put("tFileInputDelimited_6", true);
				end_Hash.put("tFileInputDelimited_6", System.currentTimeMillis());

				/**
				 * [tFileInputDelimited_6 end ] stop
				 */

				/**
				 * [tMap_6 end ] start
				 */

				currentComponent = "tMap_6";

// ###############################
// # Lookup hashes releasing
				if (tHash_Lookup_row11 != null) {
					tHash_Lookup_row11.endGet();
				}
				globalMap.remove("tHash_Lookup_row11");

// ###############################      

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row10");
				}

				ok_Hash.put("tMap_6", true);
				end_Hash.put("tMap_6", System.currentTimeMillis());

				/**
				 * [tMap_6 end ] stop
				 */

				/**
				 * [tDBOutput_6 end ] start
				 */

				currentComponent = "tDBOutput_6";

				try {
					if (batchSizeCounter_tDBOutput_6 != 0) {
						int countSum_tDBOutput_6 = 0;

						for (int countEach_tDBOutput_6 : pstmt_tDBOutput_6.executeBatch()) {
							countSum_tDBOutput_6 += (countEach_tDBOutput_6 == java.sql.Statement.EXECUTE_FAILED ? 0
									: 1);
						}
						rowsToCommitCount_tDBOutput_6 += countSum_tDBOutput_6;

						insertedCount_tDBOutput_6 += countSum_tDBOutput_6;

					}

				} catch (java.sql.BatchUpdateException e) {
					globalMap.put(currentComponent + "_ERROR_MESSAGE", e.getMessage());

					int countSum_tDBOutput_6 = 0;
					for (int countEach_tDBOutput_6 : e.getUpdateCounts()) {
						countSum_tDBOutput_6 += (countEach_tDBOutput_6 < 0 ? 0 : countEach_tDBOutput_6);
					}
					rowsToCommitCount_tDBOutput_6 += countSum_tDBOutput_6;

					insertedCount_tDBOutput_6 += countSum_tDBOutput_6;

					System.err.println(e.getMessage());

				}
				batchSizeCounter_tDBOutput_6 = 0;

				if (pstmt_tDBOutput_6 != null) {

					pstmt_tDBOutput_6.close();
					resourceMap.remove("pstmt_tDBOutput_6");

				}
				resourceMap.put("statementClosed_tDBOutput_6", true);
				if (commitCounter_tDBOutput_6 > 0 && rowsToCommitCount_tDBOutput_6 != 0) {

				}
				conn_tDBOutput_6.commit();
				if (commitCounter_tDBOutput_6 > 0 && rowsToCommitCount_tDBOutput_6 != 0) {

					rowsToCommitCount_tDBOutput_6 = 0;
				}
				commitCounter_tDBOutput_6 = 0;

				conn_tDBOutput_6.close();

				resourceMap.put("finish_tDBOutput_6", true);

				nb_line_deleted_tDBOutput_6 = nb_line_deleted_tDBOutput_6 + deletedCount_tDBOutput_6;
				nb_line_update_tDBOutput_6 = nb_line_update_tDBOutput_6 + updatedCount_tDBOutput_6;
				nb_line_inserted_tDBOutput_6 = nb_line_inserted_tDBOutput_6 + insertedCount_tDBOutput_6;
				nb_line_rejected_tDBOutput_6 = nb_line_rejected_tDBOutput_6 + rejectedCount_tDBOutput_6;

				globalMap.put("tDBOutput_6_NB_LINE", nb_line_tDBOutput_6);
				globalMap.put("tDBOutput_6_NB_LINE_UPDATED", nb_line_update_tDBOutput_6);
				globalMap.put("tDBOutput_6_NB_LINE_INSERTED", nb_line_inserted_tDBOutput_6);
				globalMap.put("tDBOutput_6_NB_LINE_DELETED", nb_line_deleted_tDBOutput_6);
				globalMap.put("tDBOutput_6_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_6);

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "copyOfcopyOfcopyOfduplicated");
				}

				ok_Hash.put("tDBOutput_6", true);
				end_Hash.put("tDBOutput_6", System.currentTimeMillis());

				/**
				 * [tDBOutput_6 end ] stop
				 */

				/**
				 * [tFileOutputDelimited_5 end ] start
				 */

				currentComponent = "tFileOutputDelimited_5";

				if (outtFileOutputDelimited_5 != null) {
					outtFileOutputDelimited_5.flush();
					outtFileOutputDelimited_5.close();
				}

				globalMap.put("tFileOutputDelimited_5_NB_LINE", nb_line_tFileOutputDelimited_5);
				globalMap.put("tFileOutputDelimited_5_FILE_NAME", fileName_tFileOutputDelimited_5);

				resourceMap.put("finish_tFileOutputDelimited_5", true);

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "copyOfcopyOfprimaryFail");
				}

				ok_Hash.put("tFileOutputDelimited_5", true);
				end_Hash.put("tFileOutputDelimited_5", System.currentTimeMillis());

				/**
				 * [tFileOutputDelimited_5 end ] stop
				 */

			} // end the resume

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			// free memory for "tMap_6"
			globalMap.remove("tHash_Lookup_row11");

			try {

				/**
				 * [tFileInputDelimited_6 finally ] start
				 */

				currentComponent = "tFileInputDelimited_6";

				/**
				 * [tFileInputDelimited_6 finally ] stop
				 */

				/**
				 * [tMap_6 finally ] start
				 */

				currentComponent = "tMap_6";

				/**
				 * [tMap_6 finally ] stop
				 */

				/**
				 * [tDBOutput_6 finally ] start
				 */

				currentComponent = "tDBOutput_6";

				try {
					if (resourceMap.get("statementClosed_tDBOutput_6") == null) {
						java.sql.PreparedStatement pstmtToClose_tDBOutput_6 = null;
						if ((pstmtToClose_tDBOutput_6 = (java.sql.PreparedStatement) resourceMap
								.remove("pstmt_tDBOutput_6")) != null) {
							pstmtToClose_tDBOutput_6.close();
						}
					}
				} finally {
					if (resourceMap.get("finish_tDBOutput_6") == null) {
						java.sql.Connection ctn_tDBOutput_6 = null;
						if ((ctn_tDBOutput_6 = (java.sql.Connection) resourceMap.get("conn_tDBOutput_6")) != null) {
							try {
								ctn_tDBOutput_6.close();
							} catch (java.sql.SQLException sqlEx_tDBOutput_6) {
								String errorMessage_tDBOutput_6 = "failed to close the connection in tDBOutput_6 :"
										+ sqlEx_tDBOutput_6.getMessage();
								System.err.println(errorMessage_tDBOutput_6);
							}
						}
					}
				}

				/**
				 * [tDBOutput_6 finally ] stop
				 */

				/**
				 * [tFileOutputDelimited_5 finally ] start
				 */

				currentComponent = "tFileOutputDelimited_5";

				if (resourceMap.get("finish_tFileOutputDelimited_5") == null) {

					java.io.Writer outtFileOutputDelimited_5 = (java.io.Writer) resourceMap
							.get("out_tFileOutputDelimited_5");
					if (outtFileOutputDelimited_5 != null) {
						outtFileOutputDelimited_5.flush();
						outtFileOutputDelimited_5.close();
					}

				}

				/**
				 * [tFileOutputDelimited_5 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tFileInputDelimited_6_SUBPROCESS_STATE", 1);
	}

	public static class row5Struct implements routines.system.IPersistableComparableLookupRow<row5Struct> {
		final static byte[] commonByteArrayLock_GROMED_dump_gros_med_brut = new byte[0];
		static byte[] commonByteArray_GROMED_dump_gros_med_brut = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public String codeCIS;

		public String getCodeCIS() {
			return this.codeCIS;
		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + ((this.codeCIS == null) ? 0 : this.codeCIS.hashCode());

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final row5Struct other = (row5Struct) obj;

			if (this.codeCIS == null) {
				if (other.codeCIS != null)
					return false;

			} else if (!this.codeCIS.equals(other.codeCIS))

				return false;

			return true;
		}

		public void copyDataTo(row5Struct other) {

			other.codeCIS = this.codeCIS;

		}

		public void copyKeysDataTo(row5Struct other) {

			other.codeCIS = this.codeCIS;

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_GROMED_dump_gros_med_brut.length) {
					if (length < 1024 && commonByteArray_GROMED_dump_gros_med_brut.length == 0) {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[1024];
					} else {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_GROMED_dump_gros_med_brut, 0, length);
				strReturn = new String(commonByteArray_GROMED_dump_gros_med_brut, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_GROMED_dump_gros_med_brut.length) {
					if (length < 1024 && commonByteArray_GROMED_dump_gros_med_brut.length == 0) {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[1024];
					} else {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_GROMED_dump_gros_med_brut, 0, length);
				strReturn = new String(commonByteArray_GROMED_dump_gros_med_brut, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readKeysData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_GROMED_dump_gros_med_brut) {

				try {

					int length = 0;

					this.codeCIS = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_GROMED_dump_gros_med_brut) {

				try {

					int length = 0;

					this.codeCIS = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeKeysData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.codeCIS, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.codeCIS, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		/**
		 * Fill Values data by reading ObjectInputStream.
		 */
		public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
			try {

				int length = 0;

			}

			finally {
			}

		}

		public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
			try {
				int length = 0;

			}

			finally {
			}

		}

		/**
		 * Return a byte array which represents Values data.
		 */
		public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
			try {

			} finally {
			}

		}

		public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut) {
			try {

			} finally {
			}
		}

		public boolean supportMarshaller() {
			return true;
		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("codeCIS=" + codeCIS);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row5Struct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.codeCIS, other.codeCIS);
			if (returnValue != 0) {
				return returnValue;
			}

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public void tDBInput_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tDBInput_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				row5Struct row5 = new row5Struct();

				/**
				 * [tAdvancedHash_row5 begin ] start
				 */

				ok_Hash.put("tAdvancedHash_row5", false);
				start_Hash.put("tAdvancedHash_row5", System.currentTimeMillis());

				currentComponent = "tAdvancedHash_row5";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row5");
				}

				int tos_count_tAdvancedHash_row5 = 0;

				// connection name:row5
				// source node:tDBInput_1 - inputs:(after_tFileInputDelimited_2)
				// outputs:(row5,row5) | target node:tAdvancedHash_row5 - inputs:(row5)
				// outputs:()
				// linked node: tMap_2 - inputs:(row3,row5) outputs:(duplicated,output)

				org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row5 = org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row5Struct> tHash_Lookup_row5 = org.talend.designer.components.lookup.memory.AdvancedMemoryLookup
						.<row5Struct>getLookup(matchingModeEnum_row5);

				globalMap.put("tHash_Lookup_row5", tHash_Lookup_row5);

				/**
				 * [tAdvancedHash_row5 begin ] stop
				 */

				/**
				 * [tDBInput_1 begin ] start
				 */

				ok_Hash.put("tDBInput_1", false);
				start_Hash.put("tDBInput_1", System.currentTimeMillis());

				currentComponent = "tDBInput_1";

				int tos_count_tDBInput_1 = 0;

				java.util.Calendar calendar_tDBInput_1 = java.util.Calendar.getInstance();
				calendar_tDBInput_1.set(0, 0, 0, 0, 0, 0);
				java.util.Date year0_tDBInput_1 = calendar_tDBInput_1.getTime();
				int nb_line_tDBInput_1 = 0;
				java.sql.Connection conn_tDBInput_1 = null;
				String driverClass_tDBInput_1 = "org.mariadb.jdbc.Driver";
				java.lang.Class jdbcclazz_tDBInput_1 = java.lang.Class.forName(driverClass_tDBInput_1);
				String dbUser_tDBInput_1 = context.gros_med_brut1_Login;

				final String decryptedPassword_tDBInput_1 = context.gros_med_brut1_Password;

				String dbPwd_tDBInput_1 = decryptedPassword_tDBInput_1;

				String properties_tDBInput_1 = context.gros_med_brut1_AdditionalParams;
				if (properties_tDBInput_1 == null || properties_tDBInput_1.trim().length() == 0) {
					properties_tDBInput_1 = "";
				}
				String url_tDBInput_1 = "jdbc:mariadb://" + context.gros_med_brut1_Server + ":"
						+ context.gros_med_brut1_Port + "/" + context.gros_med_brut1_Database + "?"
						+ properties_tDBInput_1;

				conn_tDBInput_1 = java.sql.DriverManager.getConnection(url_tDBInput_1, dbUser_tDBInput_1,
						dbPwd_tDBInput_1);

				java.sql.Statement stmt_tDBInput_1 = conn_tDBInput_1.createStatement();

				String dbquery_tDBInput_1 = "SELECT \n  `cis_bdpm`.`codeCIS`\nFROM `cis_bdpm`";

				globalMap.put("tDBInput_1_QUERY", dbquery_tDBInput_1);
				java.sql.ResultSet rs_tDBInput_1 = null;

				try {
					rs_tDBInput_1 = stmt_tDBInput_1.executeQuery(dbquery_tDBInput_1);
					java.sql.ResultSetMetaData rsmd_tDBInput_1 = rs_tDBInput_1.getMetaData();
					int colQtyInRs_tDBInput_1 = rsmd_tDBInput_1.getColumnCount();

					String tmpContent_tDBInput_1 = null;

					while (rs_tDBInput_1.next()) {
						nb_line_tDBInput_1++;

						if (colQtyInRs_tDBInput_1 < 1) {
							row5.codeCIS = null;
						} else {

							row5.codeCIS = routines.system.JDBCUtil.getString(rs_tDBInput_1, 1, false);
						}

						/**
						 * [tDBInput_1 begin ] stop
						 */

						/**
						 * [tDBInput_1 main ] start
						 */

						currentComponent = "tDBInput_1";

						tos_count_tDBInput_1++;

						/**
						 * [tDBInput_1 main ] stop
						 */

						/**
						 * [tDBInput_1 process_data_begin ] start
						 */

						currentComponent = "tDBInput_1";

						/**
						 * [tDBInput_1 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row5 main ] start
						 */

						currentComponent = "tAdvancedHash_row5";

						if (execStat) {
							runStat.updateStatOnConnection(iterateId, 1, 1

									, "row5"

							);
						}

						row5Struct row5_HashRow = new row5Struct();

						row5_HashRow.codeCIS = row5.codeCIS;

						tHash_Lookup_row5.put(row5_HashRow);

						tos_count_tAdvancedHash_row5++;

						/**
						 * [tAdvancedHash_row5 main ] stop
						 */

						/**
						 * [tAdvancedHash_row5 process_data_begin ] start
						 */

						currentComponent = "tAdvancedHash_row5";

						/**
						 * [tAdvancedHash_row5 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row5 process_data_end ] start
						 */

						currentComponent = "tAdvancedHash_row5";

						/**
						 * [tAdvancedHash_row5 process_data_end ] stop
						 */

						/**
						 * [tDBInput_1 process_data_end ] start
						 */

						currentComponent = "tDBInput_1";

						/**
						 * [tDBInput_1 process_data_end ] stop
						 */

						/**
						 * [tDBInput_1 end ] start
						 */

						currentComponent = "tDBInput_1";

					}
				} finally {
					if (rs_tDBInput_1 != null) {
						rs_tDBInput_1.close();
					}
					if (stmt_tDBInput_1 != null) {
						stmt_tDBInput_1.close();
					}
					if (conn_tDBInput_1 != null && !conn_tDBInput_1.isClosed()) {

						conn_tDBInput_1.close();

						if ("com.mysql.cj.jdbc.Driver".equals((String) globalMap.get("driverClass_"))
								&& routines.system.BundleUtils.inOSGi()) {
							Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread")
									.getMethod("checkedShutdown").invoke(null, (Object[]) null);
						}

					}

				}

				globalMap.put("tDBInput_1_NB_LINE", nb_line_tDBInput_1);

				ok_Hash.put("tDBInput_1", true);
				end_Hash.put("tDBInput_1", System.currentTimeMillis());

				/**
				 * [tDBInput_1 end ] stop
				 */

				/**
				 * [tAdvancedHash_row5 end ] start
				 */

				currentComponent = "tAdvancedHash_row5";

				tHash_Lookup_row5.endPut();

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row5");
				}

				ok_Hash.put("tAdvancedHash_row5", true);
				end_Hash.put("tAdvancedHash_row5", System.currentTimeMillis());

				/**
				 * [tAdvancedHash_row5 end ] stop
				 */

			} // end the resume

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tDBInput_1 finally ] start
				 */

				currentComponent = "tDBInput_1";

				/**
				 * [tDBInput_1 finally ] stop
				 */

				/**
				 * [tAdvancedHash_row5 finally ] start
				 */

				currentComponent = "tAdvancedHash_row5";

				/**
				 * [tAdvancedHash_row5 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBInput_1_SUBPROCESS_STATE", 1);
	}

	public static class row4Struct implements routines.system.IPersistableComparableLookupRow<row4Struct> {
		final static byte[] commonByteArrayLock_GROMED_dump_gros_med_brut = new byte[0];
		static byte[] commonByteArray_GROMED_dump_gros_med_brut = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public String codeCIS;

		public String getCodeCIS() {
			return this.codeCIS;
		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + ((this.codeCIS == null) ? 0 : this.codeCIS.hashCode());

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final row4Struct other = (row4Struct) obj;

			if (this.codeCIS == null) {
				if (other.codeCIS != null)
					return false;

			} else if (!this.codeCIS.equals(other.codeCIS))

				return false;

			return true;
		}

		public void copyDataTo(row4Struct other) {

			other.codeCIS = this.codeCIS;

		}

		public void copyKeysDataTo(row4Struct other) {

			other.codeCIS = this.codeCIS;

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_GROMED_dump_gros_med_brut.length) {
					if (length < 1024 && commonByteArray_GROMED_dump_gros_med_brut.length == 0) {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[1024];
					} else {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_GROMED_dump_gros_med_brut, 0, length);
				strReturn = new String(commonByteArray_GROMED_dump_gros_med_brut, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_GROMED_dump_gros_med_brut.length) {
					if (length < 1024 && commonByteArray_GROMED_dump_gros_med_brut.length == 0) {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[1024];
					} else {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_GROMED_dump_gros_med_brut, 0, length);
				strReturn = new String(commonByteArray_GROMED_dump_gros_med_brut, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readKeysData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_GROMED_dump_gros_med_brut) {

				try {

					int length = 0;

					this.codeCIS = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_GROMED_dump_gros_med_brut) {

				try {

					int length = 0;

					this.codeCIS = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeKeysData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.codeCIS, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.codeCIS, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		/**
		 * Fill Values data by reading ObjectInputStream.
		 */
		public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
			try {

				int length = 0;

			}

			finally {
			}

		}

		public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
			try {
				int length = 0;

			}

			finally {
			}

		}

		/**
		 * Return a byte array which represents Values data.
		 */
		public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
			try {

			} finally {
			}

		}

		public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut) {
			try {

			} finally {
			}
		}

		public boolean supportMarshaller() {
			return true;
		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("codeCIS=" + codeCIS);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row4Struct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.codeCIS, other.codeCIS);
			if (returnValue != 0) {
				return returnValue;
			}

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public void tDBInput_2Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tDBInput_2_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				row4Struct row4 = new row4Struct();

				/**
				 * [tAdvancedHash_row4 begin ] start
				 */

				ok_Hash.put("tAdvancedHash_row4", false);
				start_Hash.put("tAdvancedHash_row4", System.currentTimeMillis());

				currentComponent = "tAdvancedHash_row4";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row4");
				}

				int tos_count_tAdvancedHash_row4 = 0;

				// connection name:row4
				// source node:tDBInput_2 - inputs:(after_tFileInputDelimited_3)
				// outputs:(row4,row4) | target node:tAdvancedHash_row4 - inputs:(row4)
				// outputs:()
				// linked node: tMap_3 - inputs:(row2,row4) outputs:(duplicated1,reject)

				org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row4 = org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row4Struct> tHash_Lookup_row4 = org.talend.designer.components.lookup.memory.AdvancedMemoryLookup
						.<row4Struct>getLookup(matchingModeEnum_row4);

				globalMap.put("tHash_Lookup_row4", tHash_Lookup_row4);

				/**
				 * [tAdvancedHash_row4 begin ] stop
				 */

				/**
				 * [tDBInput_2 begin ] start
				 */

				ok_Hash.put("tDBInput_2", false);
				start_Hash.put("tDBInput_2", System.currentTimeMillis());

				currentComponent = "tDBInput_2";

				int tos_count_tDBInput_2 = 0;

				java.util.Calendar calendar_tDBInput_2 = java.util.Calendar.getInstance();
				calendar_tDBInput_2.set(0, 0, 0, 0, 0, 0);
				java.util.Date year0_tDBInput_2 = calendar_tDBInput_2.getTime();
				int nb_line_tDBInput_2 = 0;
				java.sql.Connection conn_tDBInput_2 = null;
				String driverClass_tDBInput_2 = "org.mariadb.jdbc.Driver";
				java.lang.Class jdbcclazz_tDBInput_2 = java.lang.Class.forName(driverClass_tDBInput_2);
				String dbUser_tDBInput_2 = context.gros_med_brut1_Login;

				final String decryptedPassword_tDBInput_2 = context.gros_med_brut1_Password;

				String dbPwd_tDBInput_2 = decryptedPassword_tDBInput_2;

				String properties_tDBInput_2 = context.gros_med_brut1_AdditionalParams;
				if (properties_tDBInput_2 == null || properties_tDBInput_2.trim().length() == 0) {
					properties_tDBInput_2 = "";
				}
				String url_tDBInput_2 = "jdbc:mariadb://" + context.gros_med_brut1_Server + ":"
						+ context.gros_med_brut1_Port + "/" + context.gros_med_brut1_Database + "?"
						+ properties_tDBInput_2;

				conn_tDBInput_2 = java.sql.DriverManager.getConnection(url_tDBInput_2, dbUser_tDBInput_2,
						dbPwd_tDBInput_2);

				java.sql.Statement stmt_tDBInput_2 = conn_tDBInput_2.createStatement();

				String dbquery_tDBInput_2 = "SELECT \n  `cis_bdpm`.`codeCIS`\nFROM `cis_bdpm`";

				globalMap.put("tDBInput_2_QUERY", dbquery_tDBInput_2);
				java.sql.ResultSet rs_tDBInput_2 = null;

				try {
					rs_tDBInput_2 = stmt_tDBInput_2.executeQuery(dbquery_tDBInput_2);
					java.sql.ResultSetMetaData rsmd_tDBInput_2 = rs_tDBInput_2.getMetaData();
					int colQtyInRs_tDBInput_2 = rsmd_tDBInput_2.getColumnCount();

					String tmpContent_tDBInput_2 = null;

					while (rs_tDBInput_2.next()) {
						nb_line_tDBInput_2++;

						if (colQtyInRs_tDBInput_2 < 1) {
							row4.codeCIS = null;
						} else {

							row4.codeCIS = routines.system.JDBCUtil.getString(rs_tDBInput_2, 1, false);
						}

						/**
						 * [tDBInput_2 begin ] stop
						 */

						/**
						 * [tDBInput_2 main ] start
						 */

						currentComponent = "tDBInput_2";

						tos_count_tDBInput_2++;

						/**
						 * [tDBInput_2 main ] stop
						 */

						/**
						 * [tDBInput_2 process_data_begin ] start
						 */

						currentComponent = "tDBInput_2";

						/**
						 * [tDBInput_2 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row4 main ] start
						 */

						currentComponent = "tAdvancedHash_row4";

						if (execStat) {
							runStat.updateStatOnConnection(iterateId, 1, 1

									, "row4"

							);
						}

						row4Struct row4_HashRow = new row4Struct();

						row4_HashRow.codeCIS = row4.codeCIS;

						tHash_Lookup_row4.put(row4_HashRow);

						tos_count_tAdvancedHash_row4++;

						/**
						 * [tAdvancedHash_row4 main ] stop
						 */

						/**
						 * [tAdvancedHash_row4 process_data_begin ] start
						 */

						currentComponent = "tAdvancedHash_row4";

						/**
						 * [tAdvancedHash_row4 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row4 process_data_end ] start
						 */

						currentComponent = "tAdvancedHash_row4";

						/**
						 * [tAdvancedHash_row4 process_data_end ] stop
						 */

						/**
						 * [tDBInput_2 process_data_end ] start
						 */

						currentComponent = "tDBInput_2";

						/**
						 * [tDBInput_2 process_data_end ] stop
						 */

						/**
						 * [tDBInput_2 end ] start
						 */

						currentComponent = "tDBInput_2";

					}
				} finally {
					if (rs_tDBInput_2 != null) {
						rs_tDBInput_2.close();
					}
					if (stmt_tDBInput_2 != null) {
						stmt_tDBInput_2.close();
					}
					if (conn_tDBInput_2 != null && !conn_tDBInput_2.isClosed()) {

						conn_tDBInput_2.close();

						if ("com.mysql.cj.jdbc.Driver".equals((String) globalMap.get("driverClass_"))
								&& routines.system.BundleUtils.inOSGi()) {
							Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread")
									.getMethod("checkedShutdown").invoke(null, (Object[]) null);
						}

					}

				}

				globalMap.put("tDBInput_2_NB_LINE", nb_line_tDBInput_2);

				ok_Hash.put("tDBInput_2", true);
				end_Hash.put("tDBInput_2", System.currentTimeMillis());

				/**
				 * [tDBInput_2 end ] stop
				 */

				/**
				 * [tAdvancedHash_row4 end ] start
				 */

				currentComponent = "tAdvancedHash_row4";

				tHash_Lookup_row4.endPut();

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row4");
				}

				ok_Hash.put("tAdvancedHash_row4", true);
				end_Hash.put("tAdvancedHash_row4", System.currentTimeMillis());

				/**
				 * [tAdvancedHash_row4 end ] stop
				 */

			} // end the resume

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tDBInput_2 finally ] start
				 */

				currentComponent = "tDBInput_2";

				/**
				 * [tDBInput_2 finally ] stop
				 */

				/**
				 * [tAdvancedHash_row4 finally ] start
				 */

				currentComponent = "tAdvancedHash_row4";

				/**
				 * [tAdvancedHash_row4 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBInput_2_SUBPROCESS_STATE", 1);
	}

	public static class row7Struct implements routines.system.IPersistableComparableLookupRow<row7Struct> {
		final static byte[] commonByteArrayLock_GROMED_dump_gros_med_brut = new byte[0];
		static byte[] commonByteArray_GROMED_dump_gros_med_brut = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public String codeCIS;

		public String getCodeCIS() {
			return this.codeCIS;
		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + ((this.codeCIS == null) ? 0 : this.codeCIS.hashCode());

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final row7Struct other = (row7Struct) obj;

			if (this.codeCIS == null) {
				if (other.codeCIS != null)
					return false;

			} else if (!this.codeCIS.equals(other.codeCIS))

				return false;

			return true;
		}

		public void copyDataTo(row7Struct other) {

			other.codeCIS = this.codeCIS;

		}

		public void copyKeysDataTo(row7Struct other) {

			other.codeCIS = this.codeCIS;

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_GROMED_dump_gros_med_brut.length) {
					if (length < 1024 && commonByteArray_GROMED_dump_gros_med_brut.length == 0) {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[1024];
					} else {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_GROMED_dump_gros_med_brut, 0, length);
				strReturn = new String(commonByteArray_GROMED_dump_gros_med_brut, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_GROMED_dump_gros_med_brut.length) {
					if (length < 1024 && commonByteArray_GROMED_dump_gros_med_brut.length == 0) {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[1024];
					} else {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_GROMED_dump_gros_med_brut, 0, length);
				strReturn = new String(commonByteArray_GROMED_dump_gros_med_brut, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readKeysData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_GROMED_dump_gros_med_brut) {

				try {

					int length = 0;

					this.codeCIS = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_GROMED_dump_gros_med_brut) {

				try {

					int length = 0;

					this.codeCIS = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeKeysData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.codeCIS, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.codeCIS, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		/**
		 * Fill Values data by reading ObjectInputStream.
		 */
		public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
			try {

				int length = 0;

			}

			finally {
			}

		}

		public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
			try {
				int length = 0;

			}

			finally {
			}

		}

		/**
		 * Return a byte array which represents Values data.
		 */
		public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
			try {

			} finally {
			}

		}

		public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut) {
			try {

			} finally {
			}
		}

		public boolean supportMarshaller() {
			return true;
		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("codeCIS=" + codeCIS);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row7Struct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.codeCIS, other.codeCIS);
			if (returnValue != 0) {
				return returnValue;
			}

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public void tDBInput_3Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tDBInput_3_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				row7Struct row7 = new row7Struct();

				/**
				 * [tAdvancedHash_row7 begin ] start
				 */

				ok_Hash.put("tAdvancedHash_row7", false);
				start_Hash.put("tAdvancedHash_row7", System.currentTimeMillis());

				currentComponent = "tAdvancedHash_row7";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row7");
				}

				int tos_count_tAdvancedHash_row7 = 0;

				// connection name:row7
				// source node:tDBInput_3 - inputs:(after_tFileInputDelimited_4)
				// outputs:(row7,row7) | target node:tAdvancedHash_row7 - inputs:(row7)
				// outputs:()
				// linked node: tMap_4 - inputs:(row6,row7)
				// outputs:(copyOfduplicated,primaryFail)

				org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row7 = org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row7Struct> tHash_Lookup_row7 = org.talend.designer.components.lookup.memory.AdvancedMemoryLookup
						.<row7Struct>getLookup(matchingModeEnum_row7);

				globalMap.put("tHash_Lookup_row7", tHash_Lookup_row7);

				/**
				 * [tAdvancedHash_row7 begin ] stop
				 */

				/**
				 * [tDBInput_3 begin ] start
				 */

				ok_Hash.put("tDBInput_3", false);
				start_Hash.put("tDBInput_3", System.currentTimeMillis());

				currentComponent = "tDBInput_3";

				int tos_count_tDBInput_3 = 0;

				java.util.Calendar calendar_tDBInput_3 = java.util.Calendar.getInstance();
				calendar_tDBInput_3.set(0, 0, 0, 0, 0, 0);
				java.util.Date year0_tDBInput_3 = calendar_tDBInput_3.getTime();
				int nb_line_tDBInput_3 = 0;
				java.sql.Connection conn_tDBInput_3 = null;
				String driverClass_tDBInput_3 = "org.mariadb.jdbc.Driver";
				java.lang.Class jdbcclazz_tDBInput_3 = java.lang.Class.forName(driverClass_tDBInput_3);
				String dbUser_tDBInput_3 = context.gros_med_brut1_Login;

				final String decryptedPassword_tDBInput_3 = context.gros_med_brut1_Password;

				String dbPwd_tDBInput_3 = decryptedPassword_tDBInput_3;

				String properties_tDBInput_3 = context.gros_med_brut1_AdditionalParams;
				if (properties_tDBInput_3 == null || properties_tDBInput_3.trim().length() == 0) {
					properties_tDBInput_3 = "";
				}
				String url_tDBInput_3 = "jdbc:mariadb://" + context.gros_med_brut1_Server + ":"
						+ context.gros_med_brut1_Port + "/" + context.gros_med_brut1_Database + "?"
						+ properties_tDBInput_3;

				conn_tDBInput_3 = java.sql.DriverManager.getConnection(url_tDBInput_3, dbUser_tDBInput_3,
						dbPwd_tDBInput_3);

				java.sql.Statement stmt_tDBInput_3 = conn_tDBInput_3.createStatement();

				String dbquery_tDBInput_3 = "SELECT \n  `cis_bdpm`.`codeCIS`\nFROM `cis_bdpm`";

				globalMap.put("tDBInput_3_QUERY", dbquery_tDBInput_3);
				java.sql.ResultSet rs_tDBInput_3 = null;

				try {
					rs_tDBInput_3 = stmt_tDBInput_3.executeQuery(dbquery_tDBInput_3);
					java.sql.ResultSetMetaData rsmd_tDBInput_3 = rs_tDBInput_3.getMetaData();
					int colQtyInRs_tDBInput_3 = rsmd_tDBInput_3.getColumnCount();

					String tmpContent_tDBInput_3 = null;

					while (rs_tDBInput_3.next()) {
						nb_line_tDBInput_3++;

						if (colQtyInRs_tDBInput_3 < 1) {
							row7.codeCIS = null;
						} else {

							row7.codeCIS = routines.system.JDBCUtil.getString(rs_tDBInput_3, 1, false);
						}

						/**
						 * [tDBInput_3 begin ] stop
						 */

						/**
						 * [tDBInput_3 main ] start
						 */

						currentComponent = "tDBInput_3";

						tos_count_tDBInput_3++;

						/**
						 * [tDBInput_3 main ] stop
						 */

						/**
						 * [tDBInput_3 process_data_begin ] start
						 */

						currentComponent = "tDBInput_3";

						/**
						 * [tDBInput_3 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row7 main ] start
						 */

						currentComponent = "tAdvancedHash_row7";

						if (execStat) {
							runStat.updateStatOnConnection(iterateId, 1, 1

									, "row7"

							);
						}

						row7Struct row7_HashRow = new row7Struct();

						row7_HashRow.codeCIS = row7.codeCIS;

						tHash_Lookup_row7.put(row7_HashRow);

						tos_count_tAdvancedHash_row7++;

						/**
						 * [tAdvancedHash_row7 main ] stop
						 */

						/**
						 * [tAdvancedHash_row7 process_data_begin ] start
						 */

						currentComponent = "tAdvancedHash_row7";

						/**
						 * [tAdvancedHash_row7 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row7 process_data_end ] start
						 */

						currentComponent = "tAdvancedHash_row7";

						/**
						 * [tAdvancedHash_row7 process_data_end ] stop
						 */

						/**
						 * [tDBInput_3 process_data_end ] start
						 */

						currentComponent = "tDBInput_3";

						/**
						 * [tDBInput_3 process_data_end ] stop
						 */

						/**
						 * [tDBInput_3 end ] start
						 */

						currentComponent = "tDBInput_3";

					}
				} finally {
					if (rs_tDBInput_3 != null) {
						rs_tDBInput_3.close();
					}
					if (stmt_tDBInput_3 != null) {
						stmt_tDBInput_3.close();
					}
					if (conn_tDBInput_3 != null && !conn_tDBInput_3.isClosed()) {

						conn_tDBInput_3.close();

						if ("com.mysql.cj.jdbc.Driver".equals((String) globalMap.get("driverClass_"))
								&& routines.system.BundleUtils.inOSGi()) {
							Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread")
									.getMethod("checkedShutdown").invoke(null, (Object[]) null);
						}

					}

				}

				globalMap.put("tDBInput_3_NB_LINE", nb_line_tDBInput_3);

				ok_Hash.put("tDBInput_3", true);
				end_Hash.put("tDBInput_3", System.currentTimeMillis());

				/**
				 * [tDBInput_3 end ] stop
				 */

				/**
				 * [tAdvancedHash_row7 end ] start
				 */

				currentComponent = "tAdvancedHash_row7";

				tHash_Lookup_row7.endPut();

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row7");
				}

				ok_Hash.put("tAdvancedHash_row7", true);
				end_Hash.put("tAdvancedHash_row7", System.currentTimeMillis());

				/**
				 * [tAdvancedHash_row7 end ] stop
				 */

			} // end the resume

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tDBInput_3 finally ] start
				 */

				currentComponent = "tDBInput_3";

				/**
				 * [tDBInput_3 finally ] stop
				 */

				/**
				 * [tAdvancedHash_row7 finally ] start
				 */

				currentComponent = "tAdvancedHash_row7";

				/**
				 * [tAdvancedHash_row7 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBInput_3_SUBPROCESS_STATE", 1);
	}

	public static class row9Struct implements routines.system.IPersistableComparableLookupRow<row9Struct> {
		final static byte[] commonByteArrayLock_GROMED_dump_gros_med_brut = new byte[0];
		static byte[] commonByteArray_GROMED_dump_gros_med_brut = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public String codeCIS;

		public String getCodeCIS() {
			return this.codeCIS;
		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + ((this.codeCIS == null) ? 0 : this.codeCIS.hashCode());

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final row9Struct other = (row9Struct) obj;

			if (this.codeCIS == null) {
				if (other.codeCIS != null)
					return false;

			} else if (!this.codeCIS.equals(other.codeCIS))

				return false;

			return true;
		}

		public void copyDataTo(row9Struct other) {

			other.codeCIS = this.codeCIS;

		}

		public void copyKeysDataTo(row9Struct other) {

			other.codeCIS = this.codeCIS;

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_GROMED_dump_gros_med_brut.length) {
					if (length < 1024 && commonByteArray_GROMED_dump_gros_med_brut.length == 0) {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[1024];
					} else {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_GROMED_dump_gros_med_brut, 0, length);
				strReturn = new String(commonByteArray_GROMED_dump_gros_med_brut, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_GROMED_dump_gros_med_brut.length) {
					if (length < 1024 && commonByteArray_GROMED_dump_gros_med_brut.length == 0) {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[1024];
					} else {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_GROMED_dump_gros_med_brut, 0, length);
				strReturn = new String(commonByteArray_GROMED_dump_gros_med_brut, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readKeysData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_GROMED_dump_gros_med_brut) {

				try {

					int length = 0;

					this.codeCIS = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_GROMED_dump_gros_med_brut) {

				try {

					int length = 0;

					this.codeCIS = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeKeysData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.codeCIS, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.codeCIS, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		/**
		 * Fill Values data by reading ObjectInputStream.
		 */
		public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
			try {

				int length = 0;

			}

			finally {
			}

		}

		public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
			try {
				int length = 0;

			}

			finally {
			}

		}

		/**
		 * Return a byte array which represents Values data.
		 */
		public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
			try {

			} finally {
			}

		}

		public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut) {
			try {

			} finally {
			}
		}

		public boolean supportMarshaller() {
			return true;
		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("codeCIS=" + codeCIS);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row9Struct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.codeCIS, other.codeCIS);
			if (returnValue != 0) {
				return returnValue;
			}

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public void tDBInput_4Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tDBInput_4_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				row9Struct row9 = new row9Struct();

				/**
				 * [tAdvancedHash_row9 begin ] start
				 */

				ok_Hash.put("tAdvancedHash_row9", false);
				start_Hash.put("tAdvancedHash_row9", System.currentTimeMillis());

				currentComponent = "tAdvancedHash_row9";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row9");
				}

				int tos_count_tAdvancedHash_row9 = 0;

				// connection name:row9
				// source node:tDBInput_4 - inputs:(after_tFileInputDelimited_5)
				// outputs:(row9,row9) | target node:tAdvancedHash_row9 - inputs:(row9)
				// outputs:()
				// linked node: tMap_5 - inputs:(row8,row9)
				// outputs:(copyOfcopyOfduplicated,copyOfprimaryFail)

				org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row9 = org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row9Struct> tHash_Lookup_row9 = org.talend.designer.components.lookup.memory.AdvancedMemoryLookup
						.<row9Struct>getLookup(matchingModeEnum_row9);

				globalMap.put("tHash_Lookup_row9", tHash_Lookup_row9);

				/**
				 * [tAdvancedHash_row9 begin ] stop
				 */

				/**
				 * [tDBInput_4 begin ] start
				 */

				ok_Hash.put("tDBInput_4", false);
				start_Hash.put("tDBInput_4", System.currentTimeMillis());

				currentComponent = "tDBInput_4";

				int tos_count_tDBInput_4 = 0;

				java.util.Calendar calendar_tDBInput_4 = java.util.Calendar.getInstance();
				calendar_tDBInput_4.set(0, 0, 0, 0, 0, 0);
				java.util.Date year0_tDBInput_4 = calendar_tDBInput_4.getTime();
				int nb_line_tDBInput_4 = 0;
				java.sql.Connection conn_tDBInput_4 = null;
				String driverClass_tDBInput_4 = "org.mariadb.jdbc.Driver";
				java.lang.Class jdbcclazz_tDBInput_4 = java.lang.Class.forName(driverClass_tDBInput_4);
				String dbUser_tDBInput_4 = context.gros_med_brut1_Login;

				final String decryptedPassword_tDBInput_4 = context.gros_med_brut1_Password;

				String dbPwd_tDBInput_4 = decryptedPassword_tDBInput_4;

				String properties_tDBInput_4 = context.gros_med_brut1_AdditionalParams;
				if (properties_tDBInput_4 == null || properties_tDBInput_4.trim().length() == 0) {
					properties_tDBInput_4 = "";
				}
				String url_tDBInput_4 = "jdbc:mariadb://" + context.gros_med_brut1_Server + ":"
						+ context.gros_med_brut1_Port + "/" + context.gros_med_brut1_Database + "?"
						+ properties_tDBInput_4;

				conn_tDBInput_4 = java.sql.DriverManager.getConnection(url_tDBInput_4, dbUser_tDBInput_4,
						dbPwd_tDBInput_4);

				java.sql.Statement stmt_tDBInput_4 = conn_tDBInput_4.createStatement();

				String dbquery_tDBInput_4 = "SELECT \n  `cis_bdpm`.`codeCIS`\nFROM `cis_bdpm`";

				globalMap.put("tDBInput_4_QUERY", dbquery_tDBInput_4);
				java.sql.ResultSet rs_tDBInput_4 = null;

				try {
					rs_tDBInput_4 = stmt_tDBInput_4.executeQuery(dbquery_tDBInput_4);
					java.sql.ResultSetMetaData rsmd_tDBInput_4 = rs_tDBInput_4.getMetaData();
					int colQtyInRs_tDBInput_4 = rsmd_tDBInput_4.getColumnCount();

					String tmpContent_tDBInput_4 = null;

					while (rs_tDBInput_4.next()) {
						nb_line_tDBInput_4++;

						if (colQtyInRs_tDBInput_4 < 1) {
							row9.codeCIS = null;
						} else {

							row9.codeCIS = routines.system.JDBCUtil.getString(rs_tDBInput_4, 1, false);
						}

						/**
						 * [tDBInput_4 begin ] stop
						 */

						/**
						 * [tDBInput_4 main ] start
						 */

						currentComponent = "tDBInput_4";

						tos_count_tDBInput_4++;

						/**
						 * [tDBInput_4 main ] stop
						 */

						/**
						 * [tDBInput_4 process_data_begin ] start
						 */

						currentComponent = "tDBInput_4";

						/**
						 * [tDBInput_4 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row9 main ] start
						 */

						currentComponent = "tAdvancedHash_row9";

						if (execStat) {
							runStat.updateStatOnConnection(iterateId, 1, 1

									, "row9"

							);
						}

						row9Struct row9_HashRow = new row9Struct();

						row9_HashRow.codeCIS = row9.codeCIS;

						tHash_Lookup_row9.put(row9_HashRow);

						tos_count_tAdvancedHash_row9++;

						/**
						 * [tAdvancedHash_row9 main ] stop
						 */

						/**
						 * [tAdvancedHash_row9 process_data_begin ] start
						 */

						currentComponent = "tAdvancedHash_row9";

						/**
						 * [tAdvancedHash_row9 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row9 process_data_end ] start
						 */

						currentComponent = "tAdvancedHash_row9";

						/**
						 * [tAdvancedHash_row9 process_data_end ] stop
						 */

						/**
						 * [tDBInput_4 process_data_end ] start
						 */

						currentComponent = "tDBInput_4";

						/**
						 * [tDBInput_4 process_data_end ] stop
						 */

						/**
						 * [tDBInput_4 end ] start
						 */

						currentComponent = "tDBInput_4";

					}
				} finally {
					if (rs_tDBInput_4 != null) {
						rs_tDBInput_4.close();
					}
					if (stmt_tDBInput_4 != null) {
						stmt_tDBInput_4.close();
					}
					if (conn_tDBInput_4 != null && !conn_tDBInput_4.isClosed()) {

						conn_tDBInput_4.close();

						if ("com.mysql.cj.jdbc.Driver".equals((String) globalMap.get("driverClass_"))
								&& routines.system.BundleUtils.inOSGi()) {
							Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread")
									.getMethod("checkedShutdown").invoke(null, (Object[]) null);
						}

					}

				}

				globalMap.put("tDBInput_4_NB_LINE", nb_line_tDBInput_4);

				ok_Hash.put("tDBInput_4", true);
				end_Hash.put("tDBInput_4", System.currentTimeMillis());

				/**
				 * [tDBInput_4 end ] stop
				 */

				/**
				 * [tAdvancedHash_row9 end ] start
				 */

				currentComponent = "tAdvancedHash_row9";

				tHash_Lookup_row9.endPut();

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row9");
				}

				ok_Hash.put("tAdvancedHash_row9", true);
				end_Hash.put("tAdvancedHash_row9", System.currentTimeMillis());

				/**
				 * [tAdvancedHash_row9 end ] stop
				 */

			} // end the resume

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tDBInput_4 finally ] start
				 */

				currentComponent = "tDBInput_4";

				/**
				 * [tDBInput_4 finally ] stop
				 */

				/**
				 * [tAdvancedHash_row9 finally ] start
				 */

				currentComponent = "tAdvancedHash_row9";

				/**
				 * [tAdvancedHash_row9 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBInput_4_SUBPROCESS_STATE", 1);
	}

	public static class row11Struct implements routines.system.IPersistableComparableLookupRow<row11Struct> {
		final static byte[] commonByteArrayLock_GROMED_dump_gros_med_brut = new byte[0];
		static byte[] commonByteArray_GROMED_dump_gros_med_brut = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public String codeCIS;

		public String getCodeCIS() {
			return this.codeCIS;
		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + ((this.codeCIS == null) ? 0 : this.codeCIS.hashCode());

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final row11Struct other = (row11Struct) obj;

			if (this.codeCIS == null) {
				if (other.codeCIS != null)
					return false;

			} else if (!this.codeCIS.equals(other.codeCIS))

				return false;

			return true;
		}

		public void copyDataTo(row11Struct other) {

			other.codeCIS = this.codeCIS;

		}

		public void copyKeysDataTo(row11Struct other) {

			other.codeCIS = this.codeCIS;

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_GROMED_dump_gros_med_brut.length) {
					if (length < 1024 && commonByteArray_GROMED_dump_gros_med_brut.length == 0) {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[1024];
					} else {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_GROMED_dump_gros_med_brut, 0, length);
				strReturn = new String(commonByteArray_GROMED_dump_gros_med_brut, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_GROMED_dump_gros_med_brut.length) {
					if (length < 1024 && commonByteArray_GROMED_dump_gros_med_brut.length == 0) {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[1024];
					} else {
						commonByteArray_GROMED_dump_gros_med_brut = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_GROMED_dump_gros_med_brut, 0, length);
				strReturn = new String(commonByteArray_GROMED_dump_gros_med_brut, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readKeysData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_GROMED_dump_gros_med_brut) {

				try {

					int length = 0;

					this.codeCIS = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_GROMED_dump_gros_med_brut) {

				try {

					int length = 0;

					this.codeCIS = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeKeysData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.codeCIS, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.codeCIS, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		/**
		 * Fill Values data by reading ObjectInputStream.
		 */
		public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
			try {

				int length = 0;

			}

			finally {
			}

		}

		public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
			try {
				int length = 0;

			}

			finally {
			}

		}

		/**
		 * Return a byte array which represents Values data.
		 */
		public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
			try {

			} finally {
			}

		}

		public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut) {
			try {

			} finally {
			}
		}

		public boolean supportMarshaller() {
			return true;
		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("codeCIS=" + codeCIS);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row11Struct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.codeCIS, other.codeCIS);
			if (returnValue != 0) {
				return returnValue;
			}

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public void tDBInput_5Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tDBInput_5_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				row11Struct row11 = new row11Struct();

				/**
				 * [tAdvancedHash_row11 begin ] start
				 */

				ok_Hash.put("tAdvancedHash_row11", false);
				start_Hash.put("tAdvancedHash_row11", System.currentTimeMillis());

				currentComponent = "tAdvancedHash_row11";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row11");
				}

				int tos_count_tAdvancedHash_row11 = 0;

				// connection name:row11
				// source node:tDBInput_5 - inputs:(after_tFileInputDelimited_6)
				// outputs:(row11,row11) | target node:tAdvancedHash_row11 - inputs:(row11)
				// outputs:()
				// linked node: tMap_6 - inputs:(row10,row11)
				// outputs:(copyOfcopyOfcopyOfduplicated,copyOfcopyOfprimaryFail)

				org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row11 = org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row11Struct> tHash_Lookup_row11 = org.talend.designer.components.lookup.memory.AdvancedMemoryLookup
						.<row11Struct>getLookup(matchingModeEnum_row11);

				globalMap.put("tHash_Lookup_row11", tHash_Lookup_row11);

				/**
				 * [tAdvancedHash_row11 begin ] stop
				 */

				/**
				 * [tDBInput_5 begin ] start
				 */

				ok_Hash.put("tDBInput_5", false);
				start_Hash.put("tDBInput_5", System.currentTimeMillis());

				currentComponent = "tDBInput_5";

				int tos_count_tDBInput_5 = 0;

				java.util.Calendar calendar_tDBInput_5 = java.util.Calendar.getInstance();
				calendar_tDBInput_5.set(0, 0, 0, 0, 0, 0);
				java.util.Date year0_tDBInput_5 = calendar_tDBInput_5.getTime();
				int nb_line_tDBInput_5 = 0;
				java.sql.Connection conn_tDBInput_5 = null;
				String driverClass_tDBInput_5 = "org.mariadb.jdbc.Driver";
				java.lang.Class jdbcclazz_tDBInput_5 = java.lang.Class.forName(driverClass_tDBInput_5);
				String dbUser_tDBInput_5 = context.gros_med_brut1_Login;

				final String decryptedPassword_tDBInput_5 = context.gros_med_brut1_Password;

				String dbPwd_tDBInput_5 = decryptedPassword_tDBInput_5;

				String properties_tDBInput_5 = context.gros_med_brut1_AdditionalParams;
				if (properties_tDBInput_5 == null || properties_tDBInput_5.trim().length() == 0) {
					properties_tDBInput_5 = "";
				}
				String url_tDBInput_5 = "jdbc:mariadb://" + context.gros_med_brut1_Server + ":"
						+ context.gros_med_brut1_Port + "/" + context.gros_med_brut1_Database + "?"
						+ properties_tDBInput_5;

				conn_tDBInput_5 = java.sql.DriverManager.getConnection(url_tDBInput_5, dbUser_tDBInput_5,
						dbPwd_tDBInput_5);

				java.sql.Statement stmt_tDBInput_5 = conn_tDBInput_5.createStatement();

				String dbquery_tDBInput_5 = "SELECT \n  `cis_bdpm`.`codeCIS`\nFROM `cis_bdpm`";

				globalMap.put("tDBInput_5_QUERY", dbquery_tDBInput_5);
				java.sql.ResultSet rs_tDBInput_5 = null;

				try {
					rs_tDBInput_5 = stmt_tDBInput_5.executeQuery(dbquery_tDBInput_5);
					java.sql.ResultSetMetaData rsmd_tDBInput_5 = rs_tDBInput_5.getMetaData();
					int colQtyInRs_tDBInput_5 = rsmd_tDBInput_5.getColumnCount();

					String tmpContent_tDBInput_5 = null;

					while (rs_tDBInput_5.next()) {
						nb_line_tDBInput_5++;

						if (colQtyInRs_tDBInput_5 < 1) {
							row11.codeCIS = null;
						} else {

							row11.codeCIS = routines.system.JDBCUtil.getString(rs_tDBInput_5, 1, false);
						}

						/**
						 * [tDBInput_5 begin ] stop
						 */

						/**
						 * [tDBInput_5 main ] start
						 */

						currentComponent = "tDBInput_5";

						tos_count_tDBInput_5++;

						/**
						 * [tDBInput_5 main ] stop
						 */

						/**
						 * [tDBInput_5 process_data_begin ] start
						 */

						currentComponent = "tDBInput_5";

						/**
						 * [tDBInput_5 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row11 main ] start
						 */

						currentComponent = "tAdvancedHash_row11";

						if (execStat) {
							runStat.updateStatOnConnection(iterateId, 1, 1

									, "row11"

							);
						}

						row11Struct row11_HashRow = new row11Struct();

						row11_HashRow.codeCIS = row11.codeCIS;

						tHash_Lookup_row11.put(row11_HashRow);

						tos_count_tAdvancedHash_row11++;

						/**
						 * [tAdvancedHash_row11 main ] stop
						 */

						/**
						 * [tAdvancedHash_row11 process_data_begin ] start
						 */

						currentComponent = "tAdvancedHash_row11";

						/**
						 * [tAdvancedHash_row11 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row11 process_data_end ] start
						 */

						currentComponent = "tAdvancedHash_row11";

						/**
						 * [tAdvancedHash_row11 process_data_end ] stop
						 */

						/**
						 * [tDBInput_5 process_data_end ] start
						 */

						currentComponent = "tDBInput_5";

						/**
						 * [tDBInput_5 process_data_end ] stop
						 */

						/**
						 * [tDBInput_5 end ] start
						 */

						currentComponent = "tDBInput_5";

					}
				} finally {
					if (rs_tDBInput_5 != null) {
						rs_tDBInput_5.close();
					}
					if (stmt_tDBInput_5 != null) {
						stmt_tDBInput_5.close();
					}
					if (conn_tDBInput_5 != null && !conn_tDBInput_5.isClosed()) {

						conn_tDBInput_5.close();

						if ("com.mysql.cj.jdbc.Driver".equals((String) globalMap.get("driverClass_"))
								&& routines.system.BundleUtils.inOSGi()) {
							Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread")
									.getMethod("checkedShutdown").invoke(null, (Object[]) null);
						}

					}

				}

				globalMap.put("tDBInput_5_NB_LINE", nb_line_tDBInput_5);

				ok_Hash.put("tDBInput_5", true);
				end_Hash.put("tDBInput_5", System.currentTimeMillis());

				/**
				 * [tDBInput_5 end ] stop
				 */

				/**
				 * [tAdvancedHash_row11 end ] start
				 */

				currentComponent = "tAdvancedHash_row11";

				tHash_Lookup_row11.endPut();

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row11");
				}

				ok_Hash.put("tAdvancedHash_row11", true);
				end_Hash.put("tAdvancedHash_row11", System.currentTimeMillis());

				/**
				 * [tAdvancedHash_row11 end ] stop
				 */

			} // end the resume

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tDBInput_5 finally ] start
				 */

				currentComponent = "tDBInput_5";

				/**
				 * [tDBInput_5 finally ] stop
				 */

				/**
				 * [tAdvancedHash_row11 finally ] start
				 */

				currentComponent = "tAdvancedHash_row11";

				/**
				 * [tAdvancedHash_row11 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBInput_5_SUBPROCESS_STATE", 1);
	}

	public void tPostjob_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tPostjob_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				/**
				 * [tPostjob_1 begin ] start
				 */

				ok_Hash.put("tPostjob_1", false);
				start_Hash.put("tPostjob_1", System.currentTimeMillis());

				currentComponent = "tPostjob_1";

				int tos_count_tPostjob_1 = 0;

				/**
				 * [tPostjob_1 begin ] stop
				 */

				/**
				 * [tPostjob_1 main ] start
				 */

				currentComponent = "tPostjob_1";

				tos_count_tPostjob_1++;

				/**
				 * [tPostjob_1 main ] stop
				 */

				/**
				 * [tPostjob_1 process_data_begin ] start
				 */

				currentComponent = "tPostjob_1";

				/**
				 * [tPostjob_1 process_data_begin ] stop
				 */

				/**
				 * [tPostjob_1 process_data_end ] start
				 */

				currentComponent = "tPostjob_1";

				/**
				 * [tPostjob_1 process_data_end ] stop
				 */

				/**
				 * [tPostjob_1 end ] start
				 */

				currentComponent = "tPostjob_1";

				ok_Hash.put("tPostjob_1", true);
				end_Hash.put("tPostjob_1", System.currentTimeMillis());

				if (execStat) {
					runStat.updateStatOnConnection("OnComponentOk1", 0, "ok");
				}
				tChronometerStop_1Process(globalMap);

				/**
				 * [tPostjob_1 end ] stop
				 */
			} // end the resume

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tPostjob_1 finally ] start
				 */

				currentComponent = "tPostjob_1";

				/**
				 * [tPostjob_1 finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tPostjob_1_SUBPROCESS_STATE", 1);
	}

	public void tChronometerStop_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tChronometerStop_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				/**
				 * [tChronometerStop_1 begin ] start
				 */

				ok_Hash.put("tChronometerStop_1", false);
				start_Hash.put("tChronometerStop_1", System.currentTimeMillis());

				currentComponent = "tChronometerStop_1";

				int tos_count_tChronometerStop_1 = 0;

				long timetChronometerStop_1;

				timetChronometerStop_1 = System.currentTimeMillis() - startTime;

				System.out.print("[ tChronometerStop_1 ]  ");

				System.out.print("   " + timetChronometerStop_1 / 1000 + "seconds   ");

				System.out.println("Dump de gros_med_brut: " + "  " + timetChronometerStop_1 + " milliseconds");

				Long currentTimetChronometerStop_1 = System.currentTimeMillis();
				globalMap.put("tChronometerStop_1", currentTimetChronometerStop_1);

				globalMap.put("tChronometerStop_1_STOPTIME", currentTimetChronometerStop_1);
				globalMap.put("tChronometerStop_1_DURATION", timetChronometerStop_1);

				/**
				 * [tChronometerStop_1 begin ] stop
				 */

				/**
				 * [tChronometerStop_1 main ] start
				 */

				currentComponent = "tChronometerStop_1";

				tos_count_tChronometerStop_1++;

				/**
				 * [tChronometerStop_1 main ] stop
				 */

				/**
				 * [tChronometerStop_1 process_data_begin ] start
				 */

				currentComponent = "tChronometerStop_1";

				/**
				 * [tChronometerStop_1 process_data_begin ] stop
				 */

				/**
				 * [tChronometerStop_1 process_data_end ] start
				 */

				currentComponent = "tChronometerStop_1";

				/**
				 * [tChronometerStop_1 process_data_end ] stop
				 */

				/**
				 * [tChronometerStop_1 end ] start
				 */

				currentComponent = "tChronometerStop_1";

				ok_Hash.put("tChronometerStop_1", true);
				end_Hash.put("tChronometerStop_1", System.currentTimeMillis());

				/**
				 * [tChronometerStop_1 end ] stop
				 */
			} // end the resume

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tChronometerStop_1 finally ] start
				 */

				currentComponent = "tChronometerStop_1";

				/**
				 * [tChronometerStop_1 finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tChronometerStop_1_SUBPROCESS_STATE", 1);
	}

	public String resuming_logs_dir_path = null;
	public String resuming_checkpoint_path = null;
	public String parent_part_launcher = null;
	private String resumeEntryMethodName = null;
	private boolean globalResumeTicket = false;

	public boolean watch = false;
	// portStats is null, it means don't execute the statistics
	public Integer portStats = null;
	public int portTraces = 4334;
	public String clientHost;
	public String defaultClientHost = "localhost";
	public String contextStr = "DSIM";
	public boolean isDefaultContext = true;
	public String pid = "0";
	public String rootPid = null;
	public String fatherPid = null;
	public String fatherNode = null;
	public long startTime = 0;
	public boolean isChildJob = false;
	public String log4jLevel = "";

	private boolean enableLogStash;

	private boolean execStat = true;

	private ThreadLocal<java.util.Map<String, String>> threadLocal = new ThreadLocal<java.util.Map<String, String>>() {
		protected java.util.Map<String, String> initialValue() {
			java.util.Map<String, String> threadRunResultMap = new java.util.HashMap<String, String>();
			threadRunResultMap.put("errorCode", null);
			threadRunResultMap.put("status", "");
			return threadRunResultMap;
		};
	};

	protected PropertiesWithType context_param = new PropertiesWithType();
	public java.util.Map<String, Object> parentContextMap = new java.util.HashMap<String, Object>();

	public String status = "";

	public static void main(String[] args) {
		final dump_gros_med_brut dump_gros_med_brutClass = new dump_gros_med_brut();

		int exitCode = dump_gros_med_brutClass.runJobInTOS(args);

		System.exit(exitCode);
	}

	public String[][] runJob(String[] args) {

		int exitCode = runJobInTOS(args);
		String[][] bufferValue = new String[][] { { Integer.toString(exitCode) } };

		return bufferValue;
	}

	public boolean hastBufferOutputComponent() {
		boolean hastBufferOutput = false;

		return hastBufferOutput;
	}

	public int runJobInTOS(String[] args) {
		// reset status
		status = "";

		String lastStr = "";
		for (String arg : args) {
			if (arg.equalsIgnoreCase("--context_param")) {
				lastStr = arg;
			} else if (lastStr.equals("")) {
				evalParam(arg);
			} else {
				evalParam(lastStr + " " + arg);
				lastStr = "";
			}
		}
		enableLogStash = "true".equalsIgnoreCase(System.getProperty("audit.enabled"));

		if (clientHost == null) {
			clientHost = defaultClientHost;
		}

		if (pid == null || "0".equals(pid)) {
			pid = TalendString.getAsciiRandomString(6);
		}

		if (rootPid == null) {
			rootPid = pid;
		}
		if (fatherPid == null) {
			fatherPid = pid;
		} else {
			isChildJob = true;
		}

		if (portStats != null) {
			// portStats = -1; //for testing
			if (portStats < 0 || portStats > 65535) {
				// issue:10869, the portStats is invalid, so this client socket can't open
				System.err.println("The statistics socket port " + portStats + " is invalid.");
				execStat = false;
			}
		} else {
			execStat = false;
		}
		boolean inOSGi = routines.system.BundleUtils.inOSGi();

		if (inOSGi) {
			java.util.Dictionary<String, Object> jobProperties = routines.system.BundleUtils.getJobProperties(jobName);

			if (jobProperties != null && jobProperties.get("context") != null) {
				contextStr = (String) jobProperties.get("context");
			}
		}

		try {
			// call job/subjob with an existing context, like: --context=production. if
			// without this parameter, there will use the default context instead.
			java.io.InputStream inContext = dump_gros_med_brut.class.getClassLoader()
					.getResourceAsStream("gromed/dump_gros_med_brut_0_1/contexts/" + contextStr + ".properties");
			if (inContext == null) {
				inContext = dump_gros_med_brut.class.getClassLoader()
						.getResourceAsStream("config/contexts/" + contextStr + ".properties");
			}
			if (inContext != null) {
				try {
					// defaultProps is in order to keep the original context value
					if (context != null && context.isEmpty()) {
						defaultProps.load(inContext);
						context = new ContextProperties(defaultProps);
					}
				} finally {
					inContext.close();
				}
			} else if (!isDefaultContext) {
				// print info and job continue to run, for case: context_param is not empty.
				System.err.println("Could not find the context " + contextStr);
			}

			if (!context_param.isEmpty()) {
				context.putAll(context_param);
				// set types for params from parentJobs
				for (Object key : context_param.keySet()) {
					String context_key = key.toString();
					String context_type = context_param.getContextType(context_key);
					context.setContextType(context_key, context_type);

				}
			}
			class ContextProcessing {
				private void processContext_0() {
					context.setContextType("source", "id_String");
					if (context.getStringValue("source") == null) {
						context.source = null;
					} else {
						context.source = (String) context.getProperty("source");
					}
					context.setContextType("GrosMed_Login", "id_String");
					if (context.getStringValue("GrosMed_Login") == null) {
						context.GrosMed_Login = null;
					} else {
						context.GrosMed_Login = (String) context.getProperty("GrosMed_Login");
					}
					context.setContextType("GrosMed_Port", "id_String");
					if (context.getStringValue("GrosMed_Port") == null) {
						context.GrosMed_Port = null;
					} else {
						context.GrosMed_Port = (String) context.getProperty("GrosMed_Port");
					}
					context.setContextType("GrosMed_Server", "id_String");
					if (context.getStringValue("GrosMed_Server") == null) {
						context.GrosMed_Server = null;
					} else {
						context.GrosMed_Server = (String) context.getProperty("GrosMed_Server");
					}
					context.setContextType("GrosMed_Database", "id_String");
					if (context.getStringValue("GrosMed_Database") == null) {
						context.GrosMed_Database = null;
					} else {
						context.GrosMed_Database = (String) context.getProperty("GrosMed_Database");
					}
					context.setContextType("GrosMed_Password", "id_Password");
					if (context.getStringValue("GrosMed_Password") == null) {
						context.GrosMed_Password = null;
					} else {
						String pwd_GrosMed_Password_value = context.getProperty("GrosMed_Password");
						context.GrosMed_Password = null;
						if (pwd_GrosMed_Password_value != null) {
							if (context_param.containsKey("GrosMed_Password")) {// no need to decrypt if it come from
																				// program argument or parent job
																				// runtime
								context.GrosMed_Password = pwd_GrosMed_Password_value;
							} else if (!pwd_GrosMed_Password_value.isEmpty()) {
								try {
									context.GrosMed_Password = routines.system.PasswordEncryptUtil
											.decryptPassword(pwd_GrosMed_Password_value);
									context.put("GrosMed_Password", context.GrosMed_Password);
								} catch (java.lang.RuntimeException e) {
									// do nothing
								}
							}
						}
					}
					context.setContextType("GrosMed_AdditionalParams", "id_String");
					if (context.getStringValue("GrosMed_AdditionalParams") == null) {
						context.GrosMed_AdditionalParams = null;
					} else {
						context.GrosMed_AdditionalParams = (String) context.getProperty("GrosMed_AdditionalParams");
					}
					context.setContextType("gros_med_brut_Port", "id_String");
					if (context.getStringValue("gros_med_brut_Port") == null) {
						context.gros_med_brut_Port = null;
					} else {
						context.gros_med_brut_Port = (String) context.getProperty("gros_med_brut_Port");
					}
					context.setContextType("gros_med_brut_AdditionalParams", "id_String");
					if (context.getStringValue("gros_med_brut_AdditionalParams") == null) {
						context.gros_med_brut_AdditionalParams = null;
					} else {
						context.gros_med_brut_AdditionalParams = (String) context
								.getProperty("gros_med_brut_AdditionalParams");
					}
					context.setContextType("gros_med_brut_Login", "id_String");
					if (context.getStringValue("gros_med_brut_Login") == null) {
						context.gros_med_brut_Login = null;
					} else {
						context.gros_med_brut_Login = (String) context.getProperty("gros_med_brut_Login");
					}
					context.setContextType("gros_med_brut_Database", "id_String");
					if (context.getStringValue("gros_med_brut_Database") == null) {
						context.gros_med_brut_Database = null;
					} else {
						context.gros_med_brut_Database = (String) context.getProperty("gros_med_brut_Database");
					}
					context.setContextType("gros_med_brut_Password", "id_Password");
					if (context.getStringValue("gros_med_brut_Password") == null) {
						context.gros_med_brut_Password = null;
					} else {
						String pwd_gros_med_brut_Password_value = context.getProperty("gros_med_brut_Password");
						context.gros_med_brut_Password = null;
						if (pwd_gros_med_brut_Password_value != null) {
							if (context_param.containsKey("gros_med_brut_Password")) {// no need to decrypt if it come
																						// from program argument or
																						// parent job runtime
								context.gros_med_brut_Password = pwd_gros_med_brut_Password_value;
							} else if (!pwd_gros_med_brut_Password_value.isEmpty()) {
								try {
									context.gros_med_brut_Password = routines.system.PasswordEncryptUtil
											.decryptPassword(pwd_gros_med_brut_Password_value);
									context.put("gros_med_brut_Password", context.gros_med_brut_Password);
								} catch (java.lang.RuntimeException e) {
									// do nothing
								}
							}
						}
					}
					context.setContextType("gros_med_brut_Server", "id_String");
					if (context.getStringValue("gros_med_brut_Server") == null) {
						context.gros_med_brut_Server = null;
					} else {
						context.gros_med_brut_Server = (String) context.getProperty("gros_med_brut_Server");
					}
					context.setContextType("gros_med_brut1_Port", "id_String");
					if (context.getStringValue("gros_med_brut1_Port") == null) {
						context.gros_med_brut1_Port = null;
					} else {
						context.gros_med_brut1_Port = (String) context.getProperty("gros_med_brut1_Port");
					}
					context.setContextType("gros_med_brut1_Database", "id_String");
					if (context.getStringValue("gros_med_brut1_Database") == null) {
						context.gros_med_brut1_Database = null;
					} else {
						context.gros_med_brut1_Database = (String) context.getProperty("gros_med_brut1_Database");
					}
					context.setContextType("gros_med_brut1_AdditionalParams", "id_String");
					if (context.getStringValue("gros_med_brut1_AdditionalParams") == null) {
						context.gros_med_brut1_AdditionalParams = null;
					} else {
						context.gros_med_brut1_AdditionalParams = (String) context
								.getProperty("gros_med_brut1_AdditionalParams");
					}
					context.setContextType("gros_med_brut1_Server", "id_String");
					if (context.getStringValue("gros_med_brut1_Server") == null) {
						context.gros_med_brut1_Server = null;
					} else {
						context.gros_med_brut1_Server = (String) context.getProperty("gros_med_brut1_Server");
					}
					context.setContextType("gros_med_brut1_Login", "id_String");
					if (context.getStringValue("gros_med_brut1_Login") == null) {
						context.gros_med_brut1_Login = null;
					} else {
						context.gros_med_brut1_Login = (String) context.getProperty("gros_med_brut1_Login");
					}
					context.setContextType("gros_med_brut1_Password", "id_Password");
					if (context.getStringValue("gros_med_brut1_Password") == null) {
						context.gros_med_brut1_Password = null;
					} else {
						String pwd_gros_med_brut1_Password_value = context.getProperty("gros_med_brut1_Password");
						context.gros_med_brut1_Password = null;
						if (pwd_gros_med_brut1_Password_value != null) {
							if (context_param.containsKey("gros_med_brut1_Password")) {// no need to decrypt if it come
																						// from program argument or
																						// parent job runtime
								context.gros_med_brut1_Password = pwd_gros_med_brut1_Password_value;
							} else if (!pwd_gros_med_brut1_Password_value.isEmpty()) {
								try {
									context.gros_med_brut1_Password = routines.system.PasswordEncryptUtil
											.decryptPassword(pwd_gros_med_brut1_Password_value);
									context.put("gros_med_brut1_Password", context.gros_med_brut1_Password);
								} catch (java.lang.RuntimeException e) {
									// do nothing
								}
							}
						}
					}
				}

				public void processAllContext() {
					processContext_0();
				}
			}

			new ContextProcessing().processAllContext();
		} catch (java.io.IOException ie) {
			System.err.println("Could not load context " + contextStr);
			ie.printStackTrace();
		}

		// get context value from parent directly
		if (parentContextMap != null && !parentContextMap.isEmpty()) {
			if (parentContextMap.containsKey("source")) {
				context.source = (String) parentContextMap.get("source");
			}
			if (parentContextMap.containsKey("GrosMed_Login")) {
				context.GrosMed_Login = (String) parentContextMap.get("GrosMed_Login");
			}
			if (parentContextMap.containsKey("GrosMed_Port")) {
				context.GrosMed_Port = (String) parentContextMap.get("GrosMed_Port");
			}
			if (parentContextMap.containsKey("GrosMed_Server")) {
				context.GrosMed_Server = (String) parentContextMap.get("GrosMed_Server");
			}
			if (parentContextMap.containsKey("GrosMed_Database")) {
				context.GrosMed_Database = (String) parentContextMap.get("GrosMed_Database");
			}
			if (parentContextMap.containsKey("GrosMed_Password")) {
				context.GrosMed_Password = (java.lang.String) parentContextMap.get("GrosMed_Password");
			}
			if (parentContextMap.containsKey("GrosMed_AdditionalParams")) {
				context.GrosMed_AdditionalParams = (String) parentContextMap.get("GrosMed_AdditionalParams");
			}
			if (parentContextMap.containsKey("gros_med_brut_Port")) {
				context.gros_med_brut_Port = (String) parentContextMap.get("gros_med_brut_Port");
			}
			if (parentContextMap.containsKey("gros_med_brut_AdditionalParams")) {
				context.gros_med_brut_AdditionalParams = (String) parentContextMap
						.get("gros_med_brut_AdditionalParams");
			}
			if (parentContextMap.containsKey("gros_med_brut_Login")) {
				context.gros_med_brut_Login = (String) parentContextMap.get("gros_med_brut_Login");
			}
			if (parentContextMap.containsKey("gros_med_brut_Database")) {
				context.gros_med_brut_Database = (String) parentContextMap.get("gros_med_brut_Database");
			}
			if (parentContextMap.containsKey("gros_med_brut_Password")) {
				context.gros_med_brut_Password = (java.lang.String) parentContextMap.get("gros_med_brut_Password");
			}
			if (parentContextMap.containsKey("gros_med_brut_Server")) {
				context.gros_med_brut_Server = (String) parentContextMap.get("gros_med_brut_Server");
			}
			if (parentContextMap.containsKey("gros_med_brut1_Port")) {
				context.gros_med_brut1_Port = (String) parentContextMap.get("gros_med_brut1_Port");
			}
			if (parentContextMap.containsKey("gros_med_brut1_Database")) {
				context.gros_med_brut1_Database = (String) parentContextMap.get("gros_med_brut1_Database");
			}
			if (parentContextMap.containsKey("gros_med_brut1_AdditionalParams")) {
				context.gros_med_brut1_AdditionalParams = (String) parentContextMap
						.get("gros_med_brut1_AdditionalParams");
			}
			if (parentContextMap.containsKey("gros_med_brut1_Server")) {
				context.gros_med_brut1_Server = (String) parentContextMap.get("gros_med_brut1_Server");
			}
			if (parentContextMap.containsKey("gros_med_brut1_Login")) {
				context.gros_med_brut1_Login = (String) parentContextMap.get("gros_med_brut1_Login");
			}
			if (parentContextMap.containsKey("gros_med_brut1_Password")) {
				context.gros_med_brut1_Password = (java.lang.String) parentContextMap.get("gros_med_brut1_Password");
			}
		}

		// Resume: init the resumeUtil
		resumeEntryMethodName = ResumeUtil.getResumeEntryMethodName(resuming_checkpoint_path);
		resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);
		resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName, jobName, contextStr, jobVersion);

		List<String> parametersToEncrypt = new java.util.ArrayList<String>();
		parametersToEncrypt.add("GrosMed_Password");
		parametersToEncrypt.add("gros_med_brut_Password");
		parametersToEncrypt.add("gros_med_brut1_Password");
		// Resume: jobStart
		resumeUtil.addLog("JOB_STARTED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "",
				"", "", "", "", resumeUtil.convertToJsonText(context, parametersToEncrypt));

		if (execStat) {
			try {
				runStat.openSocket(!isChildJob);
				runStat.setAllPID(rootPid, fatherPid, pid, jobName);
				runStat.startThreadStat(clientHost, portStats);
				runStat.updateStatOnJob(RunStat.JOBSTART, fatherNode);
			} catch (java.io.IOException ioException) {
				ioException.printStackTrace();
			}
		}

		java.util.concurrent.ConcurrentHashMap<Object, Object> concurrentHashMap = new java.util.concurrent.ConcurrentHashMap<Object, Object>();
		globalMap.put("concurrentHashMap", concurrentHashMap);

		long startUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		long endUsedMemory = 0;
		long end = 0;

		startTime = System.currentTimeMillis();

		this.globalResumeTicket = true;// to run tPreJob

		this.globalResumeTicket = false;// to run others jobs

		try {
			errorCode = null;
			tFileInputDelimited_1Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tFileInputDelimited_1) {
			globalMap.put("tFileInputDelimited_1_SUBPROCESS_STATE", -1);

			e_tFileInputDelimited_1.printStackTrace();

		}

		this.globalResumeTicket = true;// to run tPostJob

		try {
			errorCode = null;
			tPostjob_1Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tPostjob_1) {
			globalMap.put("tPostjob_1_SUBPROCESS_STATE", -1);

			e_tPostjob_1.printStackTrace();

		}

		end = System.currentTimeMillis();

		if (watch) {
			System.out.println((end - startTime) + " milliseconds");
		}

		endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		if (false) {
			System.out.println(
					(endUsedMemory - startUsedMemory) + " bytes memory increase when running : dump_gros_med_brut");
		}

		if (execStat) {
			runStat.updateStatOnJob(RunStat.JOBEND, fatherNode);
			runStat.stopThreadStat();
		}
		int returnCode = 0;

		if (errorCode == null) {
			returnCode = status != null && status.equals("failure") ? 1 : 0;
		} else {
			returnCode = errorCode.intValue();
		}
		resumeUtil.addLog("JOB_ENDED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "",
				"" + returnCode, "", "", "");

		return returnCode;

	}

	// only for OSGi env
	public void destroy() {

	}

	private java.util.Map<String, Object> getSharedConnections4REST() {
		java.util.Map<String, Object> connections = new java.util.HashMap<String, Object>();

		return connections;
	}

	private void evalParam(String arg) {
		if (arg.startsWith("--resuming_logs_dir_path")) {
			resuming_logs_dir_path = arg.substring(25);
		} else if (arg.startsWith("--resuming_checkpoint_path")) {
			resuming_checkpoint_path = arg.substring(27);
		} else if (arg.startsWith("--parent_part_launcher")) {
			parent_part_launcher = arg.substring(23);
		} else if (arg.startsWith("--watch")) {
			watch = true;
		} else if (arg.startsWith("--stat_port=")) {
			String portStatsStr = arg.substring(12);
			if (portStatsStr != null && !portStatsStr.equals("null")) {
				portStats = Integer.parseInt(portStatsStr);
			}
		} else if (arg.startsWith("--trace_port=")) {
			portTraces = Integer.parseInt(arg.substring(13));
		} else if (arg.startsWith("--client_host=")) {
			clientHost = arg.substring(14);
		} else if (arg.startsWith("--context=")) {
			contextStr = arg.substring(10);
			isDefaultContext = false;
		} else if (arg.startsWith("--father_pid=")) {
			fatherPid = arg.substring(13);
		} else if (arg.startsWith("--root_pid=")) {
			rootPid = arg.substring(11);
		} else if (arg.startsWith("--father_node=")) {
			fatherNode = arg.substring(14);
		} else if (arg.startsWith("--pid=")) {
			pid = arg.substring(6);
		} else if (arg.startsWith("--context_type")) {
			String keyValue = arg.substring(15);
			int index = -1;
			if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
				if (fatherPid == null) {
					context_param.setContextType(keyValue.substring(0, index),
							replaceEscapeChars(keyValue.substring(index + 1)));
				} else { // the subjob won't escape the especial chars
					context_param.setContextType(keyValue.substring(0, index), keyValue.substring(index + 1));
				}

			}

		} else if (arg.startsWith("--context_param")) {
			String keyValue = arg.substring(16);
			int index = -1;
			if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
				if (fatherPid == null) {
					context_param.put(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
				} else { // the subjob won't escape the especial chars
					context_param.put(keyValue.substring(0, index), keyValue.substring(index + 1));
				}
			}
		} else if (arg.startsWith("--log4jLevel=")) {
			log4jLevel = arg.substring(13);
		} else if (arg.startsWith("--audit.enabled") && arg.contains("=")) {// for trunjob call
			final int equal = arg.indexOf('=');
			final String key = arg.substring("--".length(), equal);
			System.setProperty(key, arg.substring(equal + 1));
		}
	}

	private static final String NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY = "<TALEND_NULL>";

	private final String[][] escapeChars = { { "\\\\", "\\" }, { "\\n", "\n" }, { "\\'", "\'" }, { "\\r", "\r" },
			{ "\\f", "\f" }, { "\\b", "\b" }, { "\\t", "\t" } };

	private String replaceEscapeChars(String keyValue) {

		if (keyValue == null || ("").equals(keyValue.trim())) {
			return keyValue;
		}

		StringBuilder result = new StringBuilder();
		int currIndex = 0;
		while (currIndex < keyValue.length()) {
			int index = -1;
			// judege if the left string includes escape chars
			for (String[] strArray : escapeChars) {
				index = keyValue.indexOf(strArray[0], currIndex);
				if (index >= 0) {

					result.append(keyValue.substring(currIndex, index + strArray[0].length()).replace(strArray[0],
							strArray[1]));
					currIndex = index + strArray[0].length();
					break;
				}
			}
			// if the left string doesn't include escape chars, append the left into the
			// result
			if (index < 0) {
				result.append(keyValue.substring(currIndex));
				currIndex = currIndex + keyValue.length();
			}
		}

		return result.toString();
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public String getStatus() {
		return status;
	}

	ResumeUtil resumeUtil = null;
}
/************************************************************************************************
 * 512236 characters generated by Talend Open Studio for Data Integration on the
 * 11 janvier 2023 à 13:05:36 CET
 ************************************************************************************************/