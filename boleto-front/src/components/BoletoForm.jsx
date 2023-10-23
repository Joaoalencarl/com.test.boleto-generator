import { useState, useEffect } from 'react';
import PropTypes from 'prop-types';
import axios from 'axios';

const PDFViewer = ({ pdfBytes }) => {
  const [pdfUrl, setPdfUrl] = useState(null);

  useEffect(() => {
    const pdfBlob = new Blob([new Uint8Array(pdfBytes)], { type: 'application/pdf' });

    const pdfTempUrl = window.URL.createObjectURL(pdfBlob);
    setPdfUrl(pdfTempUrl);

    return () => {
      window.URL.revokeObjectURL(pdfTempUrl);
    };
  }, [pdfBytes]);

  return (
    <div className="pdf-viewer">
      {pdfUrl && (
        <a href={pdfUrl} target="_blank" rel="noopener noreferrer">
          Abrir PDF em Nova Aba
        </a>
      )}
    </div>
  );
};

PDFViewer.propTypes = {
  pdfBytes: PropTypes.instanceOf(Uint8Array).isRequired,
};

const FileUploadForm = () => {
  const [pdfBytes, setPdfBytes] = useState(null);

  const [requestData, setRequestData] = useState({
    sacado: '',
    sacadoCpf: '',
    banco: '',
    agencia: '',
    conta: '',
    cedente: '',
    cedenteCnpj: '',
    carteira: '',
    numeroDocumento: '',
    nossoNumero: '',
    valor: '',
    dataVencimento: '',
  });

  const [error, setError] = useState(null);

  const handleFileUpload = async () => {
    try {
      if (!requestData.sacado || !requestData.banco || !requestData.agencia || !requestData.conta) {
        setError('Preencha todos os campos obrigatórios (Sacado, Banco, Agência, Conta).');
        return;
      }

      const response = await axios.post('http://localhost:8080/boleto/gerar', requestData, {
        responseType: 'arraybuffer',
      });

      setPdfBytes(response.data);
      setError(null);
    } catch (error) {
      console.error('Erro ao enviar a solicitação:', error);
      setError('Erro ao enviar a solicitação. Verifique os dados e tente novamente.');
    }
  };

  return (
    <div className="file-upload-form">
      <h1>Envio de Requisição para PDF</h1>
      <form>
        <label>
          Sacado:
          <input type="text" name="sacado" onChange={(e) => setRequestData({ ...requestData, sacado: e.target.value })} />
        </label>
        <label>
          Sacado CPF:
          <input type="text" name="sacadoCpf" onChange={(e) => setRequestData({ ...requestData, sacadoCpf: e.target.value })} />
        </label>
        <label>
          Banco:
          <input type="text" name="banco" onChange={(e) => setRequestData({ ...requestData, banco: e.target.value })} />
        </label>
        <label>
          Agência:
          <input type="text" name="agencia" onChange={(e) => setRequestData({ ...requestData, agencia: e.target.value })} />
        </label>
        <label>
          Conta:
          <input type="text" name="conta" onChange={(e) => setRequestData({ ...requestData, conta: e.target.value })} />
        </label>
        <label>
          Cedente:
          <input type="text" name="cedente" onChange={(e) => setRequestData({ ...requestData, cedente: e.target.value })} />
        </label>
        <label>
          Cedente CNPJ:
          <input type="text" name="cedenteCnpj" onChange={(e) => setRequestData({ ...requestData, cedenteCnpj: e.target.value })} />
        </label>
        <label>
          Carteira:
          <input type="text" name="carteira" onChange={(e) => setRequestData({ ...requestData, carteira: e.target.value })} />
        </label>
        <label>
          Número Documento:
          <input type="text" name="numeroDocumento" onChange={(e) => setRequestData({ ...requestData, numeroDocumento: e.target.value })} />
        </label>
        <label>
          Nosso Número:
          <input type="text" name="nossoNumero" onChange={(e) => setRequestData({ ...requestData, nossoNumero: e.target.value })} />
        </label>
        <label>
          Valor:
          <input type="text" name="valor" onChange={(e) => setRequestData({ ...requestData, valor: e.target.value })} />
        </label>
        <label>
          Data Vencimento:
          <input type="text" name="dataVencimento" onChange={(e) => setRequestData({ ...requestData, dataVencimento: e.target.value })} />
        </label>
      </form>
      {error && <div className="error">{error}</div>}
      <button onClick={handleFileUpload}>Enviar Requisição</button>
      <PDFViewer pdfBytes={pdfBytes} />
    </div>
  );
};

export default FileUploadForm;
