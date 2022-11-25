import React from 'react';

import Description from './Description';
import Languages from '../../components/CV/Languages';

import PersonalData from './PersonalData';
import Studies from '../../components/CV/Studies';
import WorkExperiences from '../../components/CV/WorkExperiences';

import { useLocation } from 'wouter';
import { useUser } from '../../hooks/useUser';
import { getAllUserData } from '../../services/CV/cvService';

const CandidateCurriculum = () => {
  const [, navigate] = useLocation();
  const { isLogged, userData, type } = useUser();

  if (!isLogged || type !== 'user') navigate('/');

  const cv = getAllUserData({ id: userData.id });

  return (
    <div className="cvPartsContainer center">
      <h2>Curriculum</h2>
      <div>
        <PersonalData data={cv} />
        <WorkExperiences data={cv.workExperience} />
        <Studies data={cv.studies} />
        <Languages data={cv.languages} />
        <Description data={cv.description} />
      </div>
    </div>
  );
};

export default CandidateCurriculum;
