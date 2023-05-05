import React from 'react';

import CompanyData from '../../components/CompanyDetails/CompanyData';
import JobsOffered from '../../components/CompanyDetails/JobsOffered';

import { useLocation } from 'wouter';

import { useUser } from '../../hooks/useUser';
import { useCompanyOffers } from '../../hooks/useCompanyOffers';

const CompanyDetail = () => {
  const [, navigate] = useLocation();
  const { isLogged, userData, type } = useUser();

  if (!isLogged || type !== 'company') navigate('/');

  const jobsOffered = useCompanyOffers({ id: userData.id });

  return (
    <div className="cvPartsContainer center">
      <h2>Company Details</h2>
      <div>
        <CompanyData data={userData} />
        <JobsOffered data={jobsOffered} />
      </div>
    </div>
  );
};

export default CompanyDetail;
