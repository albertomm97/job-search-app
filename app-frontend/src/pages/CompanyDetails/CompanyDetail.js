import React from 'react';

import CompanyData from '../../components/CompanyDetails/CompanyData';
import JobsOffered from '../../components/CompanyDetails/JobsOffered';

const CompanyDetail = () => {
  return (
    <div className="cvPartsContainer center">
      <h2>Company Details</h2>
      <div>
        <CompanyData />
        <JobsOffered />
      </div>
    </div>
  );
};

export default CompanyDetail;
