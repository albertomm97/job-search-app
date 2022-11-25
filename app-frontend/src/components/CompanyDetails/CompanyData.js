import React from 'react';

const CompanyData = ({ data }) => {
  return (
    <div className="cvPart">
      <img className="cvPic" src="/logo192.png" />
      <div className="candidateDetails">
        <h4>{data.name}</h4>
        <p>{data.description}</p>
        <p>{data.email}</p>
      </div>
    </div>
  );
};

export default CompanyData;
