import React, { useEffect, useState } from 'react';
import { getCompanyData } from '../../services/CompanyDetails/getCompanyData';

const CompanyData = () => {
  const [companyData, setCompanyData] = useState({});

  useEffect(() => {
    setCompanyData(getCompanyData());
  }, []);

  return (
    <div className="cvPart">
      <img className="cvPic" src="/logo192.png" />
      <div className="candidateDetails">
        <h4>{companyData.name}</h4>
        <p>{companyData.description}</p>
        <p>{companyData.email}</p>
      </div>
    </div>
  );
};

export default CompanyData;
