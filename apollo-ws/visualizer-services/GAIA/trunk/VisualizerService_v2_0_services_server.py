##################################################
# VisualizerService_v2_0_services_server.py
#      Generated by ZSI.generate.wsdl2dispatch.DelAuthServiceModuleWriter
#
##################################################

from VisualizerService_v2_0_services import *
from ZSI.ServiceContainer import ServiceSOAPBinding

class VisualizerService_v2_0(ServiceSOAPBinding):
    soapAction = {}
    root = {}
    _wsdl = """<?xml version=\"1.0\" ?>
<wsdl:definitions name=\"VisualizerService_v2.0\" targetNamespace=\"http://service.apollo.pitt.edu/visualizerservice/v2_0/\" xmlns:soap=\"http://schemas.xmlsoap.org/wsdl/soap/\" xmlns:tns=\"http://service.apollo.pitt.edu/visualizerservice/v2_0/\" xmlns:wsdl=\"http://schemas.xmlsoap.org/wsdl/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">
	<wsdl:types>
		<xsd:schema targetNamespace=\"http://service.apollo.pitt.edu/visualizerservice/v2_0/\" xmlns:apollo=\"http://types.apollo.pitt.edu/v2_0/\">
			<xsd:import namespace=\"http://types.apollo.pitt.edu/v2_0/\" schemaLocation=\"http://research.rods.pitt.edu/apollo-types_2.0.xsd\">
			</xsd:import>
			<xsd:element name=\"runVisualization\">
				<xsd:complexType>
					<xsd:sequence>
						<xsd:element name=\"runVisualizationMessage\" type=\"apollo:RunVisualizationMessage\"/>
					</xsd:sequence>
				</xsd:complexType>
			</xsd:element>
			<xsd:element name=\"runVisualizationResponse\">
				<xsd:complexType>
					<xsd:sequence>
						<xsd:element name=\"visualizationResult\" type=\"apollo:VisualizerResult\"/>
					</xsd:sequence>
				</xsd:complexType>
			</xsd:element>
			<xsd:element name=\"getRunStatus\">
				<xsd:complexType>
					<xsd:sequence>
						<xsd:element name=\"runId\" type=\"apollo:RunIdentification\"/>
					</xsd:sequence>
				</xsd:complexType>
			</xsd:element>
			<xsd:element name=\"getRunStatusResponse\">
				<xsd:complexType>
					<xsd:sequence>
						<xsd:element name=\"runStatus\" type=\"apollo:MethodCallStatus\"/>
					</xsd:sequence>
				</xsd:complexType>
			</xsd:element>
		</xsd:schema>
	</wsdl:types>
	<wsdl:message name=\"runVisualizationRequest\">
		<wsdl:part element=\"tns:runVisualization\" name=\"parameters\"/>
	</wsdl:message>
	<wsdl:message name=\"runVisualizationResponse\">
		<wsdl:part element=\"tns:runVisualizationResponse\" name=\"parameters\"/>
	</wsdl:message>
	<wsdl:message name=\"getRunStatusRequest\">
		<wsdl:part element=\"tns:getRunStatus\" name=\"parameters\"/>
	</wsdl:message>
	<wsdl:message name=\"getRunStatusResponse\">
		<wsdl:part element=\"tns:getRunStatusResponse\" name=\"parameters\"/>
	</wsdl:message>
	<wsdl:message name=\"getConfigurationFileForRunRequest\">
		<wsdl:part element=\"tns:getConfigurationFileForRun\" name=\"parameters\"/>
	</wsdl:message>
	<wsdl:message name=\"getConfigurationFileForRunResponse\">
		<wsdl:part element=\"tns:getConfigurationFileForRunResponse\" name=\"parameters\"/>
	</wsdl:message>
	<wsdl:portType name=\"VisualizerServiceEI\">
		<wsdl:operation name=\"runVisualization\">
			<wsdl:input message=\"tns:runVisualizationRequest\"/>
			<wsdl:output message=\"tns:runVisualizationResponse\"/>
		</wsdl:operation>
		<wsdl:operation name=\"getRunStatus\">
			<wsdl:input message=\"tns:getRunStatusRequest\"/>
			<wsdl:output message=\"tns:getRunStatusResponse\"/>
		</wsdl:operation>
	</wsdl:portType>

	<wsdl:binding name=\"VisualizerServiceBinding\" type=\"tns:VisualizerServiceEI\">
		<soap:binding style=\"document\" transport=\"http://schemas.xmlsoap.org/soap/http\"/>
		<wsdl:operation name=\"runVisualization\">
			<soap:operation soapAction=\"http://service.apollo.pitt.edu/visualizerservice/v2_0/runVisualization\"/>
			<wsdl:input>
				<soap:body use=\"literal\"/>
			</wsdl:input>
			<wsdl:output>
				<soap:body use=\"literal\"/>
			</wsdl:output>
		</wsdl:operation>
		<wsdl:operation name=\"getRunStatus\">
			<soap:operation soapAction=\"http://service.apollo.pitt.edu/visualizerservice/v2_0/getRunStatus\"/>
			<wsdl:input>
				<soap:body use=\"literal\"/>
			</wsdl:input>
			<wsdl:output>
				<soap:body use=\"literal\"/>
			</wsdl:output>
		</wsdl:operation>
	</wsdl:binding>
	<wsdl:service name=\"VisualizerService_v2.0\">
		<wsdl:port binding=\"tns:VisualizerServiceBinding\" name=\"VisualizerServiceEndpoint\">
			<soap:address location=\"http://localhost:8080/visualizerservice20/services/visualizerservice\"/>
		</wsdl:port>
		
	</wsdl:service>
</wsdl:definitions>"""

    def __init__(self, post='/visualizerservice20/services/visualizerservice', **kw):
        ServiceSOAPBinding.__init__(self, post)
        if kw.has_key('impl'):
            self.impl = kw['impl']
        self.auth_method_name = None
        if kw.has_key('auth_method_name'):
            self.auth_method_name = kw['auth_method_name']
    def authorize(self, auth_info, post, action):
        if self.auth_method_name and hasattr(self.impl, self.auth_method_name):
            return getattr(self.impl, self.auth_method_name)(auth_info, post, action)
        else:
            return 1

    def soap_runVisualization(self, ps):
        self.request = ps.Parse(runVisualizationRequest.typecode)
        parameters = self.request._runVisualizationMessage

        # If we have an implementation object use it
        if hasattr(self,'impl'):
            parameters = self.impl.runVisualization(parameters)

        result = runVisualizationResponse()
        # If we have an implementation object, copy the result 
        if hasattr(self,'impl'):
            result._visualizationResult = parameters
        return result

    soapAction['http://service.apollo.pitt.edu/visualizerservice/v2_0/runVisualization'] = 'soap_runVisualization'
    root[(runVisualizationRequest.typecode.nspname,runVisualizationRequest.typecode.pname)] = 'soap_runVisualization'

    def soap_getRunStatus(self, ps):
        self.request = ps.Parse(getRunStatusRequest.typecode)
        parameters = self.request._runId

        # If we have an implementation object use it
        if hasattr(self,'impl'):
            parameters = self.impl.getRunStatus(parameters)

        result = getRunStatusResponse()
        # If we have an implementation object, copy the result 
        if hasattr(self,'impl'):
            result._runStatus = parameters
        return result

    soapAction['http://service.apollo.pitt.edu/visualizerservice/v2_0/getRunStatus'] = 'soap_getRunStatus'
    root[(getRunStatusRequest.typecode.nspname,getRunStatusRequest.typecode.pname)] = 'soap_getRunStatus'
