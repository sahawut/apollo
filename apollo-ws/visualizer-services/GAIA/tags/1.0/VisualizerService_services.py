################################################## 
# VisualizerService_services.py 
# generated by ZSI.generate.wsdl2python
##################################################


from VisualizerService_services_types import *
import urlparse, types
from ZSI.TCcompound import ComplexType, Struct
from ZSI import client
import ZSI

# Locator
class VisualizerServiceLocator:
    VisualizerServiceEI_address = "http://localhost:8080/visualizerservice/services/visualizerservice"
    def getVisualizerServiceEIAddress(self):
        return VisualizerServiceLocator.VisualizerServiceEI_address
    def getVisualizerServiceEI(self, url=None, **kw):
        return VisualizerServiceBindingSOAP(url or VisualizerServiceLocator.VisualizerServiceEI_address, **kw)

# Methods
class VisualizerServiceBindingSOAP:
    def __init__(self, url, **kw):
        kw.setdefault("readerclass", None)
        kw.setdefault("writerclass", None)
        # no resource properties
        self.binding = client.Binding(url=url, **kw)
        # no ws-addressing

    # op: run
    def run(self, request):
        if isinstance(request, runRequest) is False:
            raise TypeError, "%s incorrect request type" % (request.__class__)
        kw = {}
        # no input wsaction
        self.binding.Send(None, None, request, soapaction="http://service.apollo.pitt.edu/visualizerservice/run", **kw)
        # no output wsaction
        response = self.binding.Receive(runResponse.typecode)
        return response

    # op: getRunStatus
    def getRunStatus(self, request):
        if isinstance(request, getRunStatusRequest) is False:
            raise TypeError, "%s incorrect request type" % (request.__class__)
        kw = {}
        # no input wsaction
        self.binding.Send(None, None, request, soapaction="http://service.apollo.pitt.edu/visualizerservice/getRunStatus", **kw)
        # no output wsaction
        response = self.binding.Receive(getRunStatusResponse.typecode)
        return response

runRequest = ns0.run_Dec().pyclass

runResponse = ns0.runResponse_Dec().pyclass

getRunStatusRequest = ns0.getRunStatus_Dec().pyclass

getRunStatusResponse = ns0.getRunStatusResponse_Dec().pyclass
