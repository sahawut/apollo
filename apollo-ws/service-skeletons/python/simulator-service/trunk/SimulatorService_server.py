##################################################
# file: SimulatorService_server.py
#
# skeleton generated by "ZSI.generate.wsdl2dispatch.ServiceModuleWriter"
#      C:\Python27\Scripts\wsdl2py-script.py --complexType simulatorservice.wsdl
#
##################################################

from ZSI.schema import GED, GTD
from ZSI.TCcompound import ComplexType, Struct
from SimulatorService_types import *
from ZSI.ServiceContainer import ServiceSOAPBinding

# Messages  
runRequest = GED("http://service.apollo.pitt.edu/simulatorservice/", "run").pyclass

runResponse = GED("http://service.apollo.pitt.edu/simulatorservice/", "runResponse").pyclass

getRunStatusRequest = GED("http://service.apollo.pitt.edu/simulatorservice/", "getRunStatus").pyclass

getRunStatusResponse = GED("http://service.apollo.pitt.edu/simulatorservice/", "getRunStatusResponse").pyclass

getSupportedLocationsRequest = GED("http://service.apollo.pitt.edu/simulatorservice/", "getSupportedLocations").pyclass

getSupportedLocationsResponse = GED("http://service.apollo.pitt.edu/simulatorservice/", "getSupportedLocationsResponse").pyclass


# Service Skeletons
class SimulatorService(ServiceSOAPBinding):
    soapAction = {}
    root = {}

    def __init__(self, post='/simulatorservice/services/simulatorservice', **kw):
        ServiceSOAPBinding.__init__(self, post)

    def soap_run(self, ps, **kw):
        request = ps.Parse(runRequest.typecode)
        return request,runResponse()

    soapAction['http://service.apollo.pitt.edu/simulatorservice/run'] = 'soap_run'
    root[(runRequest.typecode.nspname,runRequest.typecode.pname)] = 'soap_run'

    def soap_getRunStatus(self, ps, **kw):
        request = ps.Parse(getRunStatusRequest.typecode)
        return request,getRunStatusResponse()

    soapAction['http://service.apollo.pitt.edu/simulatorservice/getRunStatus'] = 'soap_getRunStatus'
    root[(getRunStatusRequest.typecode.nspname,getRunStatusRequest.typecode.pname)] = 'soap_getRunStatus'

    def soap_getSupportedLocations(self, ps, **kw):
        request = ps.Parse(getSupportedLocationsRequest.typecode)
        return request,getSupportedLocationsResponse()

    soapAction['http://service.apollo.pitt.edu/simulatorservice/getSupportedLocations'] = 'soap_getSupportedLocations'
    root[(getSupportedLocationsRequest.typecode.nspname,getSupportedLocationsRequest.typecode.pname)] = 'soap_getSupportedLocations'

