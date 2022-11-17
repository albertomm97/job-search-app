import React from 'react';

import Description from './Description';
import Languages from '../../components/CV/Languages';

import PersonalData from './PersonalData';
import Studies from '../../components/CV/Studies';
import WorkExperiences from '../../components/CV/WorkExperiences';

const CandidateCurriculum = () => {
  return (
    <div className="cvPartsContainer center">
      <h2>Curriculum</h2>
      <div>
        <PersonalData />
        <WorkExperiences />
        <Studies />
        <Languages />
        <Description />
      </div>
    </div>
  );
};

export default CandidateCurriculum;
